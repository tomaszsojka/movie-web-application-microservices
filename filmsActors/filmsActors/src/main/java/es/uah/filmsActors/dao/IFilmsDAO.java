package es.uah.filmsActors.dao;

import es.uah.filmsActors.model.Film;

import java.util.List;

public interface IFilmsDAO {

    List<Film> findAll();

    Film findFilmById(Integer idFilm);

    List<Film> findFilmsByTitle(String title);

    List<Film> findFilmsByGenre(String genre);

    List<Film> findFilmsByActorName(String actorName);

    List<Film> findFilmsByDirection(String direction);

    void saveFilm(Film film);

    void deleteFilm(Integer idFilm);

    void updateFilm(Film film);
}
