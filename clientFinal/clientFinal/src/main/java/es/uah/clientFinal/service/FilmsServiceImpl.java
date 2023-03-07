package es.uah.clientFinal.service;

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
public class FilmsServiceImpl implements IFilmsService {

    @Autowired
    RestTemplate template;

    @Autowired
    IReviewsService reviewsService;

    String url = "http://localhost:8090/api/films/films";

    @Override
    public Page<Film> findAll(Pageable pageable) {
        Film[] films = template.getForObject(url, Film[].class);
        List<Film> filmsList = Arrays.asList(films);

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Film> list;

        if (filmsList.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, filmsList.size());
            list = filmsList.subList(startItem, toIndex);
        }

        Page<Film> page = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), filmsList.size());
        return page;
    }

    @Override
    public Film findFilmById(Integer idFilm) {
        Film film = template.getForObject(url + "/" + idFilm, Film.class);
        return film;
    }

    @Override
    public Page<Film> findFilmsByTitle(String title, Pageable pageable) {
        Film[] films = template.getForObject(url + "/title/" + title, Film[].class);
        List<Film> list = Arrays.asList(films);
        Page<Film> page = new PageImpl<>(list, pageable, list.size());
        return page;
    }

    @Override
    public Page<Film> findFilmsByGenre(String genre, Pageable pageable) {
        Film[] films = template.getForObject(url + "/genre/" + genre, Film[].class);
        List<Film> list = Arrays.asList(films);
        Page<Film> page = new PageImpl<>(list, pageable, list.size());
        return page;
    }

    @Override
    public Page<Film> findFilmsByActorName(String actorName, Pageable pageable) {
        Film[] films = template.getForObject(url + "/actor/" + actorName, Film[].class);
        List<Film> list = Arrays.asList(films);
        Page<Film> page = new PageImpl<>(list, pageable, list.size());
        return page;
    }

    @Override
    public Page<Film> findFilmsByDirection(String direction, Pageable pageable) {
        Film[] films = template.getForObject(url + "/direction/" + direction, Film[].class);
        List<Film> list = Arrays.asList(films);
        Page<Film> page = new PageImpl<>(list, pageable, list.size());
        return page;
    }

    @Override
    public void saveFilm(Film film) {
        if (film.getIdFilm() != null && film.getIdFilm() > 0) {
            template.put(url, film);
        } else {
            film.setIdFilm(0);
            template.postForObject(url, film, String.class);
        }
    }

    @Override
    public void deleteFilm(Integer idFilm) {
        reviewsService.deleteReviewsByIdFilm(idFilm);
        template.delete(url + "/" + idFilm);
    }
}
