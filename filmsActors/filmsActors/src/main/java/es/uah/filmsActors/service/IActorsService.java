package es.uah.filmsActors.service;

import es.uah.filmsActors.model.Actor;

import java.util.List;

public interface IActorsService {

    List<Actor> findAll();

    Actor findActorById(Integer idActor);

    List<Actor> findActorsByName(String name);

    void addActor(Actor actor);

    void removeActor(Integer idActor);

    void updateActor(Actor actor);
}
