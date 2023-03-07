package es.uah.filmsActors.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "actors", schema="filmsactorsdb")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idActor", nullable = false)
    private Integer idActor;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "country", nullable = false, length = 45)
    private String country;

    @ManyToMany
    @JoinTable(name = "films_has_cast", joinColumns = {
            @JoinColumn(name = "Actors_idActor", referencedColumnName =
                    "idActor")}, inverseJoinColumns = {
            @JoinColumn(name = "Films_idFilm", referencedColumnName = "idFilm")})

    @JsonIgnoreProperties("actors")
    private List<Film> films;

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdActor() {
        return idActor;
    }

    public void setIdActor(Integer idActor) {
        this.idActor = idActor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Actor)) return false;
        Actor actor = (Actor) o;
        return Objects.equals(idActor, actor.idActor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idActor);
    }

    public void addFilm(Film film) {
        if (film != null) {
            getFilms().add(film);
            film.addActor(this);
        }
    }

    public void removeFilm(Film film) {
        if (film != null) {
            film.removeActor(this);
            getFilms().remove(film);
        }
    }
}