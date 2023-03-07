package es.uah.usersReviews.controller;

import es.uah.usersReviews.model.Role;
import es.uah.usersReviews.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RolesController {

    @Autowired
    IRolesService rolesService;

    @GetMapping("/roles")
    public List<Role> findAll() {
        return rolesService.findAll();
    }

    @GetMapping("/roles/{id}")
    public Role findRoleById(@PathVariable("id") Integer id) {
        return rolesService.findRoleById(id);
    }

    @PostMapping("/roles")
    public void saveRole(@RequestBody Role role) {
        rolesService.saveRole(role);
    }

    @DeleteMapping("/roles/{id}")
    public void deleteRole(@PathVariable("id") Integer id) {
        rolesService.deleteRole(id);
    }

}
