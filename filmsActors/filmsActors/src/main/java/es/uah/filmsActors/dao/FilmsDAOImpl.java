package es.uah.filmsActors.dao;

import es.uah.filmsActors.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ListFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FilmsDAOImpl implements IFilmsDAO {

    @Autowired
    IFilmsJPA filmsJPA;

    public List<Film> findAll() {
        return filmsJPA.findAll();
    }

    @Override
    public Film findFilmById(Integer idFilm) {
        Optional<Film> optional = filmsJPA.findById(idFilm);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public List<Film> findFilmsByTitle(String title) {
        return filmsJPA.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public  List<Film> findFilmsByGenre(String genre) {
        return filmsJPA.findByGenreContainingIgnoreCase(genre);
    }

    @Override
    public  List<Film> findFilmsByActorName(String actorName) {
        return filmsJPA.findByActors_nameContainingIgnoreCase(actorName);
    }

    @Override
    public List<Film> findFilmsByDirection(String direction) {
        return filmsJPA.findByDirectionContainingIgnoreCase(direction);
    }

    @Override
    public void saveFilm(Film film) {
        filmsJPA.save(film);
    }

    @Override
    public void deleteFilm(Integer idFilm) {
        Optional<Film> optional = filmsJPA.findById(idFilm);
        if (optional.isPresent()) {
            filmsJPA.deleteById(idFilm);
        } else {
//            TODO change this if check
            System.err.println("film already does not exist");
        }
    }

    @Override
    public void updateFilm(Film film) {
        filmsJPA.save(film);
    }
}
