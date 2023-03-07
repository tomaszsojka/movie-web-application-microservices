package es.uah.usersReviews.dao;

import es.uah.usersReviews.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RolesDAOImpl implements IRolesDAO {

    @Autowired
    IRolesJPA rolesJPA;

    @Override
    public List<Role> findAll() {
        return rolesJPA.findAll();
    }

    @Override
    public Role findRoleById(Integer idRole) {
        Optional<Role> optional = rolesJPA.findById(idRole);
        return optional.orElse(null);
    }

    @Override
    public void saveRole(Role role) {
        rolesJPA.save(role);
    }

    @Override
    public void deleteRole(Integer idRole) {
        rolesJPA.deleteById(idRole);
    }
}
