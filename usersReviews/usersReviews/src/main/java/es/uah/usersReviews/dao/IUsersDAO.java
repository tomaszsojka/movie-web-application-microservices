package es.uah.usersReviews.dao;

import es.uah.usersReviews.model.User;

import java.util.List;

public interface IUsersDAO {

    List<User> findAll();

    User findUserById(Integer idUser);

    List<User> findUsersByName(String name);

    List<User> findUsersByEmail(String email);

    User findUserByEmailAndPassword(String email, String password);

    void saveUser(User user);

    void deleteUser(Integer idUser);

    void updateUser(User user);

    void deleteReview(Integer idUser, Integer idReview);

    User findUserByEmail(String email);
}
