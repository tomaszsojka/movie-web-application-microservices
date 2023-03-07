package es.uah.filmsActors.dao;

import es.uah.filmsActors.model.Actor;
import es.uah.filmsActors.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFilmsJPA extends JpaRepository<Film, Integer> {

    List<Film> findByTitleContainingIgnoreCase(String title);

    List<Film> findByGenreContainingIgnoreCase(String genre);

    List<Film> findByActors_nameContainingIgnoreCase(String name);

    List<Film> findByDirectionContainingIgnoreCase(String name);
}
