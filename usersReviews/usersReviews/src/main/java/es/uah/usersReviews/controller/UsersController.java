package es.uah.usersReviews.controller;

import es.uah.usersReviews.model.User;
import es.uah.usersReviews.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    IUsersService usersService;

    @GetMapping("/users")
    public List<User> findAll() {
        return usersService.findAll();
    }

    @GetMapping("/users/{id}")
    public User findUserById(@PathVariable("id") Integer id) {
        return usersService.findUserById(id);
    }

    @GetMapping("/users/email/one/{email}")
    public User findUserByEmail(@PathVariable("email") String email) {
        return usersService.findUserByEmail(email);
    }

    @GetMapping("/users/email/{email}")
    public List<User> findUsersByEmail(@PathVariable("email") String email) {
        return usersService.findUsersByEmail(email);
    }

    @GetMapping("/users/name/{name}")
    public List<User> findUsersByName(@PathVariable("name") String name) {
        return usersService.findUsersByName(name);
    }

    @GetMapping("/users/login/{email}/{password}")
    public User findUserByEmailAndPassword(@PathVariable("email") String email, @PathVariable("password") String password) {
        return usersService.findUserByEmailAndPassword(email, password);
    }

    @PostMapping("/users")
    public void saveUser(@RequestBody User user) {
        usersService.saveUser(user);
    }

    @PutMapping("/users")
    public void updateUser(@RequestBody User user) {
        usersService.updateUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        usersService.deleteUser(id);
    }
}
