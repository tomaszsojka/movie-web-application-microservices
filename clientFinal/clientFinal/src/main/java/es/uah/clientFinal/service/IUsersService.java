package es.uah.clientFinal.service;

import es.uah.clientFinal.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUsersService {

    Page<User> findAll(Pageable pageable);

    User findUserById(Integer idUser);

    User findUserByEmail(String email);

    Page<User> findUsersByName(String name, Pageable pageable);

    Page<User> findUsersByEmail(String email, Pageable pageable);

    User login(String email, String password);

    void saveUser(User user);

    void deleteUser(Integer idUser);

}
