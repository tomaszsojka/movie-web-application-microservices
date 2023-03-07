package es.uah.usersReviews.service;

import es.uah.usersReviews.dao.IReviewsDAO;
import es.uah.usersReviews.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsServiceImpl implements IReviewsService{

    @Autowired
    IReviewsDAO reviewsDAO;

    @Override
    public List<Review> findAll() {
        return reviewsDAO.findAll();
    }

    @Override
    public List<Review> findReviewsByIdFilm(Integer idFilm) {
        return reviewsDAO.findReviewsByFilmId(idFilm);
    }

    @Override
    public Review findReviewById(Integer idReview) {
        return reviewsDAO.findReviewById(idReview);
    }

    @Override
    public void saveReview(Review review) {
        reviewsDAO.saveReview(review);
    }

    @Override
    public void deleteReview(Integer idReview) {
        reviewsDAO.deleteReview(idReview);
    }
}
