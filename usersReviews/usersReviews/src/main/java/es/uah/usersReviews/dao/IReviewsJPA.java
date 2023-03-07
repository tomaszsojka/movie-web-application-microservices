package es.uah.usersReviews.dao;

import es.uah.usersReviews.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IReviewsJPA extends JpaRepository<Review, Integer> {

    List<Review> findByIdFilm(int idFilm);

}
