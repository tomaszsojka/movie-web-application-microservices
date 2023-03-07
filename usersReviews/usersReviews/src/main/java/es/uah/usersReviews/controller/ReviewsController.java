package es.uah.usersReviews.controller;

import es.uah.usersReviews.model.Review;
import es.uah.usersReviews.service.IReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewsController {

    @Autowired
    IReviewsService reviewsService;

    @GetMapping("/reviews")
    public List<Review> findAll() {
        return reviewsService.findAll();
    }

    @GetMapping("/reviews/film/{idFilm}")
    public List<Review> findReviewByIdFilm(@PathVariable("idFilm") Integer idFilm) {
        return reviewsService.findReviewsByIdFilm(idFilm);
    }

    @GetMapping("/reviews/{id}")
    public Review findReviewById(@PathVariable("id") Integer id) {
        return reviewsService.findReviewById(id);
    }

    @PostMapping("/reviews")
    public void saveReview(@RequestBody Review review) {
        reviewsService.saveReview(review);
    }

    @DeleteMapping("/reviews/{id}")
    public void deleteReview(@PathVariable("id") Integer id) {
        reviewsService.deleteReview(id);
    }

}
