package es.uah.clientFinal.service;

import es.uah.clientFinal.model.Film;
import es.uah.clientFinal.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IReviewsService {

    Page<Review> findAll(Pageable pageable);

    Page<Review> findReviewsByIdFilm(Integer idFilm, Pageable pageable);


    Review findReviewById(Integer idReview);

    void saveReview(Review review);

    void deleteReview(Integer idReview);

    void deleteReviewsByIdFilm(Integer idFilm);
}
