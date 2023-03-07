package es.uah.filmsActors.dao;

import es.uah.filmsActors.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IActorsJPA extends JpaRepository<Actor, Integer> {

    List<Actor> findByNameContainingIgnoreCase(String name);

}
