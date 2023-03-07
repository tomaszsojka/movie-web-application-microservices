package es.uah.filmsActors.dao;

import es.uah.filmsActors.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ActorsDAOImpl implements IActorsDAO {

    @Autowired
    IActorsJPA actorsJPA;

    @Override
    public List<Actor> findAll() {
        return actorsJPA.findAll();
    }

    @Override
    public Actor findActorById(Integer idActor) {
        Optional<Actor> optional = actorsJPA.findById(idActor);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    @Override
    public List<Actor> findActorsByName(String name) {
        return actorsJPA.findByNameContainingIgnoreCase(name);
    }

    @Override
    public void saveActor(Actor actor) {
        actorsJPA.save(actor);
    }

    @Override
    public void deleteActor(Integer idActor) {
        Optional<Actor> optional = actorsJPA.findById(idActor);
        if (optional.isPresent()) {
            actorsJPA.deleteById(idActor);
        } else {
//            TODO change this if check
            System.err.println("actor already does not exist");
        }
    }

    @Override
    public void updateActor(Actor actor) {
        actorsJPA.save(actor);
    }
}
