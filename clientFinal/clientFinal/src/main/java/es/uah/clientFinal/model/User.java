package es.uah.clientFinal.model;

import java.util.List;

public class User {

    private Integer idUser;
    private String username;
    private String password;
    private String email;
    private boolean enable;
    private List<Role> roles;
    private List<Review> reviews;

    public User() {
    }

    public User(Integer idUser, String username, String password, String email, boolean enable, List<Role> roles, List<Review> reviews) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.email = email;
        this.enable = enable;
        this.roles = roles;
        this.reviews = reviews;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
