package es.uah.usersReviews.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "usersreviewsdb")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser", nullable = false)
    private Integer idUser;

    @Column(name = "username", nullable = false, length = 45)
    private String name;

    @Column(name = "password", nullable = false, length = 60)
    private String password;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "enable", nullable = false)
    private Boolean enable = false;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "users_has_authorities", joinColumns = {
            @JoinColumn(name = "Users_idUser", referencedColumnName = "idUser")}, inverseJoinColumns = {
            @JoinColumn(name = "Authorities_idRole", referencedColumnName = "idRole"
            )})
    private List<Role> roles;

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(String name) {
        this.name = name;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(idUser, user.idUser) &&
                Objects.equals(name, user.name) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(enable, user.enable) &&
                Objects.equals(reviews, user.reviews) &&
                Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, name, password, email, enable, reviews, roles);
    }

    public void addReview(Review review) {
        getReviews().add(review);
        review.setUser(this);
    }

    public void removeReview(Review review) {
        if (review != null) {
            getReviews().remove(review);
        }
    }
}