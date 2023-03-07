package es.uah.clientFinal.service;

import es.uah.clientFinal.model.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFilmsService {

    Page<Film> findAll(Pageable pageable);

    Film findFilmById(Integer idFilm);

    Page<Film> findFilmsByTitle(String title, Pageable pageable);

    Page<Film> findFilmsByGenre(String genre, Pageable pageable);

    Page<Film> findFilmsByActorName(String actorName, Pageable pageable);

    Page<Film> findFilmsByDirection(String direction, Pageable pageable);

    void saveFilm(Film film);

    void deleteFilm(Integer idFilm);

}
