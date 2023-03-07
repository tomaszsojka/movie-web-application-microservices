package es.uah.clientFinal.controller;

import es.uah.clientFinal.model.Actor;
import es.uah.clientFinal.model.Film;
import es.uah.clientFinal.paginator.PageRender;
import es.uah.clientFinal.service.IActorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cactors")
public class ActorsController {

    @Autowired
    IActorsService actorsService;

    @GetMapping(value = "/see/{id}")
    public String see(Model model, @PathVariable("id") Integer id, RedirectAttributes attributes) {
        Actor actor = actorsService.findActorById(id);
        model.addAttribute("actor", actor);
        model.addAttribute("title", "Details of the actor: " + actor.getName());
        return "actors/seeActor";
    }

    @GetMapping("/new")
    public String newFilm(Model model) {
        Actor actor = new Actor();
        model.addAttribute("title", "New actor");
        model.addAttribute("actor", actor);
        return "actors/formActor";
    }

    @GetMapping("/search")
    public String search(Model model) {
        return "actors/searchActors";
    }

    @GetMapping("/list")
    public String listActors(Model model, @RequestParam(name="page", defaultValue="0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Actor> list = actorsService.findAll(pageable);
        PageRender<Actor> pageRender = new PageRender<Actor>("/cactors/list", list);
        model.addAttribute("title", "List of all of the actors");
        model.addAttribute("listActors", list);
        model.addAttribute("page", pageRender);
        return "actors/listActors";
    }

    @GetMapping("/idActor/{id}")
    public String searchActorById(Model model, @PathVariable("id") Integer id) {
        Actor actor = actorsService.findActorById(id);
        model.addAttribute("actor", actor);
        return "actors/formActor";
    }

    @GetMapping("/name")
    public String searchActorByName(Model model, @RequestParam(name="page", defaultValue="0") int page, @RequestParam("name") String name) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Actor> list;
        if (name.equals("")) {
            list = actorsService.findAll(pageable);
        } else {
            list = actorsService.findActorsByName(name, pageable);
        }
        PageRender<Actor> pageRender = new PageRender<Actor>("/list", list);
        model.addAttribute("title", "List of the actors by name");
        model.addAttribute("listActors", list);
        model.addAttribute("page", pageRender);
        return "actors/listActors";
    }

    @PostMapping("/save/")
    public String saveActor(Model model, Actor actor, RedirectAttributes attributes) {
        actorsService.saveActor(actor);
        model.addAttribute("title", "New actor");
        attributes.addFlashAttribute("msg", "The actor data was saved!");
        return "redirect:/cactors/list";
    }

    @GetMapping("/edit/{id}")
    public String editActor(Model model, @PathVariable("id") Integer id) {
        Actor actor = actorsService.findActorById(id);
        model.addAttribute("title", "Edit actor");
        model.addAttribute("actor", actor);
        return "actors/formActor";
    }

    @GetMapping("/delete/{id}")
    public String deleteActor(Model model, @PathVariable("id") Integer id, RedirectAttributes attributes) {
        Actor actor = actorsService.findActorById(id);

        actorsService.removeActor(id);
        attributes.addFlashAttribute("msg", "The actor data was deleted!");

        return "redirect:/cactors/list";
    }
}
