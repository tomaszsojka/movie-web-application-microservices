package es.uah.filmsActors.controller;

import es.uah.filmsActors.model.Actor;
import es.uah.filmsActors.service.IActorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActorsController {

    @Autowired
    IActorsService actorsService;

    @GetMapping("/actors")
    public List<Actor> findAll() {
        return actorsService.findAll();
    }

    @GetMapping("/actors/{id}")
    public Actor findActorById(@PathVariable("id") Integer id) {
        return actorsService.findActorById(id);
    }

    @GetMapping("/actors/name/{name}")
    public List<Actor> findFilmsByTitle(@PathVariable("name") String name) {
        return actorsService.findActorsByName(name);
    }

    @PostMapping("/actors")
    public void saveActor(@RequestBody Actor actor) {
        actorsService.addActor(actor);
    }

    @PutMapping("/actors")
    public void updateActor(@RequestBody Actor actor) {
        actorsService.updateActor(actor);
    }

    @DeleteMapping("/actors/{id}")
    public void deleteActor(@PathVariable("id") Integer id) {
        actorsService.removeActor(id);
    }
}
