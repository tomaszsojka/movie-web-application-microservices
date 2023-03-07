package com.example.clientFilmsActors.service;

import com.example.clientFilmsActors.model.Actor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IActorsService {

    Page<Actor> findAll(Pageable pageable);

    Actor findActorById(Integer idActor);

    Page<Actor> findActorsByName(String name, Pageable pageable);

    void saveActor(Actor actor);

    void removeActor(Integer idActor);
}
