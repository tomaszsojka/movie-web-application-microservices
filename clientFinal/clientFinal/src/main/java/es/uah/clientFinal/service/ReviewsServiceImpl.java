package es.uah.clientFinal.service;

import es.uah.clientFinal.model.Actor;
import es.uah.clientFinal.model.Review;
import es.uah.clientFinal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ReviewsServiceImpl implements IReviewsService{

    @Autowired
    RestTemplate template;

    @Autowired
    IUsersService usersService;

    String url = "http://localhost:8090/api/users/reviews";

    @Override
    public Page<Review> findAll(Pageable pageable) {
        Review[] reviews = template.getForObject(url, Review[].class);
        List<Review> reviewsList = Arrays.asList(reviews);

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Review> list;

        if(reviewsList.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, reviewsList.size());
            list = reviewsList.subList(startItem, toIndex);
        }
        Page<Review> page = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), reviewsList.size());
        return page;
    }

    @Override
    public Page<Review> findReviewsByIdFilm(Integer idFilm, Pageable pageable) {
        Review[] reviews = template.getForObject(url+"/film/"+idFilm, Review[].class);
        List<Review> reviewsList = Arrays.asList(reviews);

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Review>list;

        if(reviewsList.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, reviewsList.size());
            list = reviewsList.subList(startItem, toIndex);
        }
        Page<Review> page = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), reviewsList.size());
        return page;
    }

    @Override
    public Review findReviewById(Integer idReview) {
        Review review = template.getForObject(url+"/"+idReview, Review.class);
        return review;
    }

    @Override
    public void saveReview(Review review) {
        review.setDate(LocalDate.now());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = usersService.findUserByEmail(email);
        review.setUser(user);
        if (review.getIdReview() != null && review.getIdReview() > 0) {
            template.put(url, review);
        } else {
            review.setIdReview(0);
            template.postForObject(url, review, String.class);
        }
    }

    @Override
    public void deleteReview(Integer idReview) {
        template.delete(url+ "/" +  idReview);
    }

    @Override
    public void deleteReviewsByIdFilm(Integer idFilm) {
        Review[] reviews = template.getForObject(url+"/film/"+idFilm, Review[].class);
        List<Review> reviewsList = Arrays.asList(reviews);

        for (Review review : reviewsList) {
            deleteReview(review.getIdReview());
        }
    }
}
