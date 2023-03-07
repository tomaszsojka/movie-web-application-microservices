package com.example.clientFilmsActors.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Actor {

    private Integer idActor;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;
    private String country;
    private List<Film> films;

    public Actor(Integer idActor, String name, LocalDate birthdate, String country, List<Film> films) {
        this.idActor = idActor;
        this.name = name;
        this.birthdate = birthdate;
        this.country = country;
        this.films = films;
    }

    public Actor() {
    }

    public Integer getIdActor() {
        return idActor;
    }

    public void setIdActor(Integer idActor) {
        this.idActor = idActor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(idActor, actor.idActor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idActor);
    }
}
