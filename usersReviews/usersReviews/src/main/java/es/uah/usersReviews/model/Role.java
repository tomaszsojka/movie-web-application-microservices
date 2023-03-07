package es.uah.usersReviews.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "authorities", schema = "usersreviewsdb")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRole", nullable = false)
    private Integer idRole;

    @Column(name = "authority", nullable = false, length = 45)
    private String authority;

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}