package com.example.clientFilmsActors.controller;

import com.example.clientFilmsActors.model.Film;
import com.example.clientFilmsActors.paginator.PageRender;
import com.example.clientFilmsActors.service.IFilmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cfilms")
public class FilmsController {

    @Autowired
    IFilmsService filmsService;

    @GetMapping(value = {"/", "/home", ""})
    public String home(Model model) {
        return "home";
    }

    @GetMapping(value = "/see/{id}")
    public String see(Model model, @PathVariable("id") Integer id, RedirectAttributes attributes) {
        Film film = filmsService.findFilmById(id);
        model.addAttribute("film", film);
        model.addAttribute("title", "Details of the film: " + film.getTitle());
        return "films/seeFilm";
    }

    @GetMapping("/new")
    public String newFilm(Model model) {
        Film film = new Film();
        model.addAttribute("title", "New film");
        model.addAttribute("film", film);
        return "films/formFilm";
    }

    @GetMapping("/search")
    public String search(Model model) {
        return "films/searchFilms";
    }

    @GetMapping("/list")
    public String listFilms(Model model, @RequestParam(name="page", defaultValue="0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Film> list = filmsService.findAll(pageable);
        PageRender<Film> pageRender = new PageRender<Film>("/cfilms/list", list);
        model.addAttribute("title", "List of all of the films");
        model.addAttribute("listFilms", list);
        model.addAttribute("page", pageRender);
        return "films/listFilms";
    }

    @GetMapping("/idFilm/{id}")
    public String searchFilmById(Model model, @PathVariable("id") Integer id) {
        Film film = filmsService.findFilmById(id);
        model.addAttribute("film", film);
        return "films/formFilm";
    }

    @GetMapping("/title")
    public String searchFilmsByTitle(Model model, @RequestParam(name="page", defaultValue="0") int page, @RequestParam("title") String title) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Film> list;
        if (title.equals("")) {
            list = filmsService.findAll(pageable);
        } else {
            list = filmsService.findFilmsByTitle(title, pageable);
        }
        PageRender<Film> pageRender = new PageRender<Film>("/list", list);
        model.addAttribute("title", "List of the films by title");
        model.addAttribute("listFilms", list);
        model.addAttribute("page", pageRender);
        return "films/listFilms";
    }

    @GetMapping("/genre")
    public String searchFilmsByGenre(Model model, @RequestParam(name="page", defaultValue="0") int page, @RequestParam("genre") String genre) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Film> list = filmsService.findFilmsByGenre(genre, pageable);
        PageRender<Film> pageRender = new PageRender<Film>("/list", list);
        model.addAttribute("title", "List of the films by genre");
        model.addAttribute("listFilms", list);
        model.addAttribute("page", pageRender);
        return "films/listFilms";
    }

    @GetMapping("/actor")
    public String searchFilmsByActorName(Model model, @RequestParam(name="page", defaultValue="0") int page, @RequestParam("actorname") String actorname) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Film> list;
        if (actorname.equals("")) {
            list = filmsService.findAll(pageable);
        } else {
            list = filmsService.findFilmsByActorName(actorname, pageable);
        }
        PageRender<Film> pageRender = new PageRender<Film>("/list", list);
        model.addAttribute("title", "List of the films by actor's name");
        model.addAttribute("listFilms", list);
        model.addAttribute("page", pageRender);
        return "films/listFilms";
    }

    @GetMapping("/direction")
    public String searchFilmsByDirection(Model model, @RequestParam(name="page", defaultValue="0") int page, @RequestParam("direction") String direction) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Film> list;
        if (direction.equals("")) {
            list = filmsService.findAll(pageable);
        } else {
            list = filmsService.findFilmsByDirection(direction, pageable);
        }
        PageRender<Film> pageRender = new PageRender<Film>("/list", list);
        model.addAttribute("title", "List of the films by director's name");
        model.addAttribute("listFilms", list);
        model.addAttribute("page", pageRender);
        return "films/listFilms";
    }

    @PostMapping("/save/")
    public String saveFilm(Model model, Film film, RedirectAttributes attributes) {
        filmsService.saveFilm(film);
        model.addAttribute("title", "New film");
        attributes.addFlashAttribute("msg", "The film data was saved!");
        return "redirect:/cfilms/list";
    }

    @GetMapping("/edit/{id}")
    public String editFilm(Model model, @PathVariable("id") Integer id) {
        Film film = filmsService.findFilmById(id);
        model.addAttribute("title", "Edit film");
        model.addAttribute("film", film);
        return "films/formFilm";
    }


    @GetMapping("/delete/{id}")
    public String deleteFilm(Model model, @PathVariable("id") Integer id, RedirectAttributes attributes) {
        Film film = filmsService.findFilmById(id);

        filmsService.removeFilm(id);
        attributes.addFlashAttribute("msg", "The film data was deleted!");

        return "redirect:/cfilms/list";
    }
}
