package es.uah.usersReviews.dao;

import es.uah.usersReviews.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReviewsDAOImpl implements IReviewsDAO{

    @Autowired
    IReviewsJPA reviewsJPA;

    @Override
    public List<Review> findAll() {
        return reviewsJPA.findAll();
    }

    @Override
    public List<Review> findReviewsByFilmId(Integer idFilm) {
        return reviewsJPA.findByIdFilm(idFilm);
    }

    @Override
    public Review findReviewById(Integer idReview) {
        Optional<Review> optional = reviewsJPA.findById(idReview);
        return optional.orElse(null);
    }

    @Override
    public void saveReview(Review review) {
        reviewsJPA.save(review);
    }

    @Override
    public void deleteReview(Integer idReview) {
        reviewsJPA.deleteById(idReview);
    }
}
