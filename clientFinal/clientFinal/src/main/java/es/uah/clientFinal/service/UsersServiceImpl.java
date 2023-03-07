package es.uah.clientFinal.service;

import es.uah.clientFinal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UsersServiceImpl implements IUsersService{

    @Autowired
    RestTemplate template;

    String url = "http://localhost:8090/api/users/users";

    @Override
    public Page<User> findAll(Pageable pageable) {
        User[] users = template.getForObject(url, User[].class);
        List<User> usersList = Arrays.asList(users);

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<User> list;

        if (usersList.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, usersList.size());
            list = usersList.subList(startItem, toIndex);
        }

        Page<User> page = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), usersList.size());
        return page;
    }

    @Override
    public User findUserById(Integer idUser) {
        User user = template.getForObject(url + "/" + idUser, User.class);
        return user;
    }

    @Override
    public User findUserByEmail(String email) {
        User user = template.getForObject(url + "/email/one/" + email, User.class);
        return user;
    }

    @Override
    public Page<User> findUsersByName(String name, Pageable pageable) {
        User[] users = template.getForObject(url + "/name/" + name, User[].class);
        List<User> list = Arrays.asList(users);
        Page<User> page = new PageImpl<>(list, pageable, list.size());
        return page;
    }

    @Override
    public Page<User> findUsersByEmail(String email, Pageable pageable) {
        User[] users = template.getForObject(url + "/email/" + email, User[].class);
        List<User> list = Arrays.asList(users);
        Page<User> page = new PageImpl<>(list, pageable, list.size());
        return page;
    }

    @Override
    public User login(String email, String password) {
        User user = template.getForObject(url+"/login/"+email+"/"+password, User.class);
        return user;
    }

    @Override
    public void saveUser(User user) {
        if (user.getIdUser() != null && user.getIdUser() > 0) {
            template.put(url, user);
        } else {
            user.setIdUser(0);
            template.postForObject(url, user, String.class);
        }
    }

    @Override
    public void deleteUser(Integer idUser) {
        template.delete(url+"/"+idUser);
    }
}
