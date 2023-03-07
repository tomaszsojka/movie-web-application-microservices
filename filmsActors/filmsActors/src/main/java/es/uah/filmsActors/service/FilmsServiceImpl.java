package es.uah.filmsActors.service;

import es.uah.filmsActors.dao.IFilmsDAO;
import es.uah.filmsActors.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmsServiceImpl implements IFilmsService {

    @Autowired
    IFilmsDAO filmsDAO;

    @Override
    public List<Film> findAll() {
        return filmsDAO.findAll();
    }

    @Override
    public Film findFilmById(Integer idFilm) {
        return filmsDAO.findFilmById(idFilm);
    }

    @Override
    public List<Film> findFilmsByTitle(String title) {
        return filmsDAO.findFilmsByTitle(title);
    }

    @Override
    public List<Film> findFilmsByGenre(String genre) { return filmsDAO.findFilmsByGenre(genre); }

    @Override
    public List<Film> findFilmsByActorName(String actorName) { return filmsDAO.findFilmsByActorName(actorName); }

    @Override
    public List<Film> findFilmsByDirection(String direction) { return filmsDAO.findFilmsByDirection(direction); }

    @Override
    public void addFilm(Film film) {
//        TODO - make it more secure
//        if (filmsDAO.findFilmById(film.getIdFilm())==null) {
            filmsDAO.saveFilm(film);
//        }
    }

    @Override
    public void removeFilm(Integer idFilm) {
        filmsDAO.deleteFilm(idFilm);
    }

    @Override
    public void updateFilm(Film film) {
        filmsDAO.updateFilm(film);
    }
}
