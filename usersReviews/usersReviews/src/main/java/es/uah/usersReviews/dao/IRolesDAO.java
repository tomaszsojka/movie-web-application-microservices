package es.uah.usersReviews.dao;

import es.uah.usersReviews.model.Role;

import java.util.List;

public interface IRolesDAO {

    List<Role> findAll();

    Role findRoleById(Integer idRole);

    void saveRole(Role role);

    void deleteRole(Integer idRole);
}
