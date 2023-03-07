package es.uah.usersReviews.service;

import es.uah.usersReviews.dao.IUsersDAO;
import es.uah.usersReviews.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements IUsersService {

    @Autowired
    IUsersDAO usersDAO;

    @Override
    public List<User> findAll() {
        return usersDAO.findAll();
    }

    @Override
    public User findUserById(Integer idUser) {
        return usersDAO.findUserById(idUser);
    }

    @Override
    public List<User> findUsersByName(String name) {
        return usersDAO.findUsersByName(name);
    }

    @Override
    public List<User> findUsersByEmail(String email) {
        return usersDAO.findUsersByEmail(email);
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        return usersDAO.findUserByEmailAndPassword(email, password);
    }

    @Override
    public User findUserByEmail(String email) {
        return usersDAO.findUserByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        usersDAO.saveUser(user);
    }

    @Override
    public void deleteUser(Integer idUser) {
        usersDAO.deleteUser(idUser);
    }

    @Override
    public void updateUser(User user) {
        usersDAO.updateUser(user);
    }

    @Override
    public void deleteReview(Integer idUser, Integer idReview) {
        usersDAO.deleteReview(idUser, idReview);
    }
}
