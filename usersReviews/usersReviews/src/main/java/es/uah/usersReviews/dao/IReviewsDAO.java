package es.uah.usersReviews.dao;

import es.uah.usersReviews.model.Review;

import java.util.List;

public interface IReviewsDAO {

    List<Review> findAll();

    List<Review> findReviewsByFilmId(Integer idFilm);

    Review findReviewById(Integer idReview);

    void saveReview(Review review);

    void deleteReview(Integer idReview);
}
