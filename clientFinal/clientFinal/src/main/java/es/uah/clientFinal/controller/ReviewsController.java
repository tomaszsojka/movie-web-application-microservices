package es.uah.clientFinal.controller;

import es.uah.clientFinal.model.Film;
import es.uah.clientFinal.model.Review;
import es.uah.clientFinal.paginator.PageRender;
import es.uah.clientFinal.service.IReviewsService;
import es.uah.clientFinal.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/creviews")
public class ReviewsController {

    @Autowired
    IReviewsService reviewsService;

    @Autowired
    IUsersService usersService;

    @GetMapping("/list")
    public String listReviews(Model model, @RequestParam(name="page", defaultValue="0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Review> list = reviewsService.findAll(pageable);
        PageRender<Review> pageRender = new PageRender<Review>("/creviews/list", list);
        model.addAttribute("title", "List of the all of the reviews");
        model.addAttribute("listReviews", list);
        model.addAttribute("page", pageRender);
        return "reviews/listReviews";
    }


    @GetMapping(value = "/see/{id}")
    public String seeFilmReviews(Model model, @RequestParam(name = "page", defaultValue = "0") int page, @PathVariable Integer id) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Review> list;
        list = reviewsService.findReviewsByIdFilm(id, pageable);

        PageRender<Review> pageRender = new PageRender<Review>("/creviews/list", list);
        model.addAttribute("title", "List of the reviews");
        model.addAttribute("listReviews", list);
        model.addAttribute("page", pageRender);
        return "reviews/listReviews";
    }

    @GetMapping("/new")
    public String newReview(Model model) {
        Review review = new Review();
        model.addAttribute("title", "New review");
        model.addAttribute("review", review);
        return "reviews/formReview";
    }

    @PostMapping("/save/")
    public String saveReview(Model model, Review review, RedirectAttributes attributes) {
        reviewsService.saveReview(review);
        model.addAttribute("title", "New review");
        attributes.addFlashAttribute("msg", "The review data was saved!");
//        attributes.addFlashAttribute("msg", result);
        return "redirect:/cfilms/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteReview(Model model, @PathVariable("id") Integer id, RedirectAttributes attributes) {
        Review review = reviewsService.findReviewById(id);
        if (review != null) {
            reviewsService.deleteReview(id);
            attributes.addFlashAttribute("msg", "Review data deleted!");
        } else {
            attributes.addFlashAttribute("msg", "Review not found!");
        }

        return "redirect:/creviews/list";
    }

}

