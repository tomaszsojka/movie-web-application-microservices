package es.uah.clientFinal.service;

import es.uah.clientFinal.model.Actor;
import es.uah.clientFinal.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ActorsServiceImpl implements IActorsService {

    @Autowired
    RestTemplate template;

    String url = "http://localhost:8090/api/films/actors";

    @Override
    public Page<Actor> findAll(Pageable pageable) {
        Actor[] actors = template.getForObject(url, Actor[].class);
        List<Actor> actorsList = Arrays.asList(actors);

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Actor> list;

        if (actorsList.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, actorsList.size());
            list = actorsList.subList(startItem, toIndex);
        }

        Page<Actor> page = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), actorsList.size());
        return page;
    }

    @Override
    public Actor findActorById(Integer idActor) {
        Actor actor = template.getForObject(url + "/" + idActor, Actor.class);
        return actor;
    }

    @Override
    public Page<Actor> findActorsByName(String name, Pageable pageable) {
        Actor[] actors = template.getForObject(url + "/name/" + name, Actor[].class);
        List<Actor> list = Arrays.asList(actors);
        Page<Actor> page = new PageImpl<>(list, pageable, list.size());
        return page;
    }

    @Override
    public void saveActor(Actor actor) {
        if (actor.getIdActor() != null && actor.getIdActor() > 0) {
            template.put(url, actor);
        } else {
            actor.setIdActor(0);
            template.postForObject(url, actor, String.class);
        }
    }

    @Override
    public void removeActor(Integer idActor) {
        template.delete(url + "/" + idActor);
    }
}
