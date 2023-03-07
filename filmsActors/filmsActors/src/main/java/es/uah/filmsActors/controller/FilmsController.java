package es.uah.filmsActors.controller;

import es.uah.filmsActors.model.Film;
import es.uah.filmsActors.service.IFilmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmsController {


    @Autowired
    IFilmsService filmsService;

    @GetMapping("/films")
    public List<Film> findAll() {
        return filmsService.findAll();
    }

    @GetMapping("/films/{id}")
    public Film findFilmById(@PathVariable("id") Integer id) {
        return filmsService.findFilmById(id);
    }

    @GetMapping("/films/title/{title}")
    public List<Film> findFilmsByTitle(@PathVariable("title") String title) {
        return filmsService.findFilmsByTitle(title);
    }

    @GetMapping("/films/genre/{genre}")
    public List<Film> findFilmsByGenre(@PathVariable("genre") String genre) {
        return filmsService.findFilmsByGenre(genre);
    }

    @GetMapping("/films/actor/{actorname}")
    public List<Film> findFilmsByActorName(@PathVariable("actorname") String actorname) {
        return filmsService.findFilmsByActorName(actorname);
    }

    @GetMapping("/films/direction/{direction}")
    public List<Film> findActorByDirection(@PathVariable("direction") String direction) {
        return filmsService.findFilmsByDirection(direction);
    }

    @PostMapping("/films")
    public void saveFilm(@RequestBody Film film) {
        filmsService.addFilm(film);
    }

    @PutMapping("/films")
    public void updateFilm(@RequestBody Film film) {
        filmsService.updateFilm(film);
    }

    @DeleteMapping("/films/{id}")
    public void deleteFilm(@PathVariable("id") Integer id) {
        filmsService.removeFilm(id);
    }
}