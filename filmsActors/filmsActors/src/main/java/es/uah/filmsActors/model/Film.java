package es.uah.filmsActors.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "films", schema="filmsactorsdb")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFilm", nullable = false)
    private Integer idFilm;

    @Column(name = "title", nullable = false, length = 45)
    private String title;

    @Column(name = "year")
    private Integer year;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "country", nullable = false, length = 45)
    private String country;

    @Column(name = "direction", nullable = false, length = 45)
    private String direction;

    @Column(name = "genre", nullable = false, length = 45)
    private String genre;

    @Column(name = "synopsis", nullable = false, length = 500)
    private String synopsis;

    @Column(name = "image", length = 250)
    private String image;

    @ManyToMany(mappedBy = "films")
    @JsonIgnoreProperties("films")
    private List<Actor> actors;

    public Film() {
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Integer idFilm) {
        this.idFilm = idFilm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film)) return false;
        Film film = (Film) o;
        return Objects.equals(idFilm, film.idFilm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFilm);
    }

    public void addActor(Actor actor) {
        if (actor != null) {
            getActors().add(actor);
        }
    }

    public void removeActor(Actor actor) {
        if (actor != null) {
            getActors().remove(actor);
        }
    }
}