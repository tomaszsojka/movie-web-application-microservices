package es.uah.usersReviews.dao;

import es.uah.usersReviews.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsersDAOImpl implements IUsersDAO{

    @Autowired
    IUsersJPA usersJPA;

    @Autowired
    IReviewsJPA reviewsJPA;

    @Override
    public List<User> findAll() {
        return usersJPA.findAll();
    }

    @Override
    public User findUserById(Integer idUser) {
        Optional<User> optional = usersJPA.findById(idUser);
        return optional.orElse(null);
    }

    @Override
    public List<User> findUsersByName(String name) {
        return usersJPA.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<User> findUsersByEmail(String email) {
        return usersJPA.findByEmailContainingIgnoreCase(email);
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        Optional<User> optional = Optional.ofNullable(usersJPA.findByEmailAndPassword(email, password));
        return optional.orElse(null);
    }

    @Override
    public User findUserByEmail(String email) {
        Optional<User> optional = usersJPA.findByEmail(email);
        return optional.orElse(null);
    }

    @Override
    public void saveUser(User user) {
        usersJPA.save(user);
    }

    @Override
    public void deleteUser(Integer idUser) {
        usersJPA.deleteById(idUser);
    }

    @Override
    public void updateUser(User user) {
        usersJPA.save(user);
    }

    @Override
    public void deleteReview(Integer idUser, Integer idReview) {
        User user = findUserById(idUser);
        if (user != null) {
            user.removeReview(reviewsJPA.findById(idReview).orElse(null));
        }
        reviewsJPA.deleteById(idReview);
    }
}
