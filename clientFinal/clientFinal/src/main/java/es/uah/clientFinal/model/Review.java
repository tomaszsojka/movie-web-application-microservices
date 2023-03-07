package es.uah.clientFinal.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Review {

    private Integer idReview;
    private Integer idFilm;
    private Integer note;
    private String rating;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private User user;

    public Review() {
    }

    public Review(Integer idReview, Integer idFilm, Integer note, String rating, LocalDate date, User user) {
        this.idReview = idReview;
        this.idFilm = idFilm;
        this.note = note;
        this.rating = rating;
        this.date = date;
        this.user = user;
    }

    public Integer getIdReview() {
        return idReview;
    }

    public void setIdReview(Integer idReview) {
        this.idReview = idReview;
    }

    public Integer getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Integer idFilm) {
        this.idFilm = idFilm;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
