package es.uah.usersReviews.dao;

import es.uah.usersReviews.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolesJPA extends JpaRepository<Role, Integer> {
}
