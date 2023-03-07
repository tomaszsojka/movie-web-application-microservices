package es.uah.usersReviews.service;

import es.uah.usersReviews.dao.IRolesDAO;
import es.uah.usersReviews.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements IRolesService{

    @Autowired
    IRolesDAO rolesDAO;

    @Override
    public List<Role> findAll() {
        return rolesDAO.findAll();
    }

    @Override
    public Role findRoleById(Integer idRole) {
        return rolesDAO.findRoleById(idRole);
    }

    @Override
    public void saveRole(Role role) {
        rolesDAO.saveRole(role);
    }

    @Override
    public void deleteRole(Integer idRole) {
        rolesDAO.deleteRole(idRole);
    }
}
