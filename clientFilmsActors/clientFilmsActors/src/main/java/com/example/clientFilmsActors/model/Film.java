package com.example.clientFilmsActors.model;

import java.util.List;
import java.util.Objects;

public class Film {

    private Integer idFilm;
    private String title;
    private Integer year;
    private Integer duration;
    private String country;
    private String direction;
    private String genre;
    private String synopsis;
    private String image;
    private List<Actor> actors;

    public Film(Integer idFilm, String title, Integer year, Integer duration, String country, String direction, String genre, String synopsis, String image, List<Actor> actors) {
        this.idFilm = idFilm;
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.country = country;
        this.direction = direction;
        this.genre = genre;
        this.synopsis = synopsis;
        this.image = image;
        this.actors = actors;
    }

    public Film() {
    }

    public Integer getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Integer idFilm) {
        this.idFilm = idFilm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(idFilm, film.idFilm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFilm);
    }
}