package es.uah.usersReviews.service;

import es.uah.usersReviews.model.User;

import java.util.List;

public interface IUsersService {

    List<User> findAll();

    User findUserById(Integer idUser);

    List<User> findUsersByName(String name);

    List<User> findUsersByEmail(String email);

    User findUserByEmailAndPassword(String email, String password);

    User findUserByEmail(String email);

    void saveUser(User user);

    void deleteUser(Integer idUser);

    void updateUser(User user);

    void deleteReview(Integer idUser, Integer idReview);

}
