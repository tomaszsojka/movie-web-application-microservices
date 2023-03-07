package es.uah.usersReviews.dao;

import es.uah.usersReviews.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IUsersJPA extends JpaRepository<User, Integer> {

    List<User> findByNameContainingIgnoreCase(String name);

    List<User> findByEmailContainingIgnoreCase(String email);

    User findByEmailAndPassword(String email, String password);

    Optional<User> findByEmail(String email);
}
