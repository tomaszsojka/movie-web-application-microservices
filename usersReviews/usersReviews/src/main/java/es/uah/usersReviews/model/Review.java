package es.uah.usersReviews.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "reviews", schema = "usersreviewsdb")
public class Review {
    @Id
    private Integer idReview;

    @Column(name = "idFilm", nullable = false)
    private Integer idFilm;

    @Column(name = "note", nullable = false)
    private Integer note;

    @Column(name = "rating", nullable = false, length = 1500)
    private String rating;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "Users_idUser", referencedColumnName = "idUser", nullable = false)
    @JsonIgnoreProperties("reviews")
    private User user;

    public Review() {}

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public Integer getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Integer idFilm) {
        this.idFilm = idFilm;
    }

    public Integer getIdReview() {
        return idReview;
    }

    public void setIdReview(Integer idReview) {
        this.idReview = idReview;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(idReview, review.idReview) &&
                Objects.equals(idFilm, review.idFilm) &&
                Objects.equals(note, review.note) &&
                Objects.equals(rating, review.rating) &&
                Objects.equals(date, review.date) &&
                Objects.equals(user, review.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idReview, idFilm, note, rating, date, user);
    }
}