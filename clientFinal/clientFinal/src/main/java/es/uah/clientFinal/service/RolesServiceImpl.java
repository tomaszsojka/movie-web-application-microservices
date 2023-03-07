package es.uah.clientFinal.service;

import es.uah.clientFinal.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class RolesServiceImpl implements IRolesService {

    @Autowired
    RestTemplate template;

    String url = "http://localhost:8090/api/users/roles";

    @Override
    public List<Role> findAll() {
        Role[] roles = template.getForObject(url, Role[].class);
        return Arrays.asList(roles);
    }

    @Override
    public Role findRoleById(Integer idRole) {
        Role role = template.getForObject(url+"/"+idRole, Role.class);
        return role;
    }

    @Override
    public void saveRole(Role role) {
        if (role.getIdRole() != null && role.getIdRole() > 0) {
            template.put(url, role);
        } else {
            role.setIdRole(0);
            template.postForObject(url, role, String.class);
        }
    }

    @Override
    public void deleteRole(Integer idRole) {
        template.delete(url + "/" + idRole);
    }
}
