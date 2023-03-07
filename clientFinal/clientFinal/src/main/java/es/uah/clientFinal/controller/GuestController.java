package es.uah.clientFinal.controller;

import es.uah.clientFinal.model.Film;
import es.uah.clientFinal.paginator.PageRender;
import es.uah.clientFinal.service.IFilmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class GuestController {


    @Autowired
    IFilmsService filmsService;

    @GetMapping(value = { ""})
    public String guest(Model model, @RequestParam(name="page", defaultValue="0") int page) {
        Pageable pageable = PageRequest.of(page, 6);
        Page<Film> list = filmsService.findAll(pageable);
        PageRender<Film> pageRender = new PageRender<Film>("/", list);
        model.addAttribute("guestListFilms", list);
        model.addAttribute("page", pageRender);
        return "guest";
    }
}
