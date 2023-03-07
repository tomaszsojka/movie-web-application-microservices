package es.uah.filmsActors.service;

import es.uah.filmsActors.dao.IActorsDAO;
import es.uah.filmsActors.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorsServiceImpl implements IActorsService {

    @Autowired
    IActorsDAO actorsDAO;

    @Override
    public List<Actor> findAll() {
        return actorsDAO.findAll();
    }

    @Override
    public Actor findActorById(Integer idActor) {
        return actorsDAO.findActorById(idActor);
    }

    @Override
    public List<Actor> findActorsByName(String name) {
        return actorsDAO.findActorsByName(name);
    }

    @Override
    public void addActor(Actor actor) {
        actorsDAO.saveActor(actor);
    }

    @Override
    public void removeActor(Integer idActor) {
        actorsDAO.deleteActor(idActor);
    }

    @Override
    public void updateActor(Actor actor) {
        actorsDAO.updateActor(actor);
    }
}
