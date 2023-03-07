package es.uah.filmsActors.service;

import es.uah.filmsActors.model.Film;

import java.util.List;

public interface IFilmsService {

    List<Film> findAll();

    Film findFilmById(Integer idFilm);

    List<Film> findFilmsByTitle(String title);

    List<Film> findFilmsByGenre(String genre);

    List<Film> findFilmsByActorName(String actorName);

    List<Film> findFilmsByDirection(String direction);

    void addFilm(Film film);

    void removeFilm(Integer idFilm);

    void updateFilm(Film film);
}
