package es.uah.clientFinal.service;

import es.uah.clientFinal.model.Role;

import java.util.List;

public interface IRolesService {

    List<Role> findAll();

    Role findRoleById(Integer idRole);

    void saveRole(Role role);

    void deleteRole(Integer idRole);

}
