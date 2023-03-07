package es.uah.clientFinal.controller;

import es.uah.clientFinal.model.Role;
import es.uah.clientFinal.model.User;
import es.uah.clientFinal.paginator.PageRender;
import es.uah.clientFinal.service.IRolesService;
import es.uah.clientFinal.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/cusers")
public class UsersController {

    @Autowired
    IUsersService usersService;

    @Autowired
    IRolesService rolesService;

    @GetMapping(value = "/see/{id}")
    public String see(Model model, @PathVariable("id") Integer id, RedirectAttributes attributes) {
        User user = usersService.findUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "Details of the user: " + user.getUsername());
        return "users/seeUser";
    }

    @GetMapping("/list")
    public String listUsers(Model model, @RequestParam(name="page", defaultValue="0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<User> list = usersService.findAll(pageable);
        PageRender<User> pageRender = new PageRender<User>("/cusers/list", list);
        model.addAttribute("title", "List of all of the users");
        model.addAttribute("listUsers", list);
        model.addAttribute("page", pageRender);
        return "users/listUsers";
    }

    @GetMapping("/search")
    public String search(Model model) {
        return "users/searchUsers";
    }

    @GetMapping("/name")
    public String searchUsersByName(Model model, @RequestParam(name="page", defaultValue="0") int page, @RequestParam("name") String name) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<User> list;
        if (name.equals("")) {
            list = usersService.findAll(pageable);
        } else {
            list = usersService.findUsersByName(name, pageable);
        }
        PageRender<User> pageRender = new PageRender<User>("/list", list);
        model.addAttribute("title", "List of the users by name");
        model.addAttribute("listUsers", list);
        model.addAttribute("page", pageRender);
        return "users/listUsers";
    }


    @GetMapping("/email")
    public String searchUsersByEmail(Model model, @RequestParam(name="page", defaultValue="0") int page, @RequestParam("email") String email) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<User> list;
        if (email.equals("")) {
            list = usersService.findAll(pageable);
        } else {
            list = usersService.findUsersByEmail(email, pageable);
        }
        PageRender<User> pageRender = new PageRender<User>("/list", list);
        model.addAttribute("title", "List of the users by email");
        model.addAttribute("listUsers", list);
        model.addAttribute("page", pageRender);
        return "users/listUsers";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        List<Role> roles = rolesService.findAll();
        model.addAttribute("title", "New user");
        model.addAttribute("allRoles", roles);
        User user = new User();
        model.addAttribute("user", user);
        return "users/formUser";
    }

    @PostMapping("/save/")
    public String saveUser(Model model, User user, RedirectAttributes attributes) {
        List<Role> roles = rolesService.findAll();
        model.addAttribute("allRoles", roles);
        usersService.saveUser(user);
        model.addAttribute("title", "New user");
        attributes.addFlashAttribute("msg", "User data saved!");
        return "redirect:/cusers/list";
    }

    @PostMapping("/register")
    public String register(Model model, User user, RedirectAttributes attributes) {
        user.setEnable(true);
        Role rol = rolesService.findRoleById(2);
        user.setRoles(Arrays.asList(rol));
        usersService.saveUser(user);
        attributes.addFlashAttribute("msg", "User data saved!");
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String registerNewUser(Model model) {
        model.addAttribute("title", "New registration");
        User user = new User();
        model.addAttribute("user", user);
        return "/register";
    }

    @GetMapping("/edit/{id}")
    public String editUser(Model model, @PathVariable("id") Integer id) {
        User user = usersService.findUserById(id);
        model.addAttribute("title", "Edit user");
        model.addAttribute("user", user);
        List<Role> roles = rolesService.findAll();
        model.addAttribute("allRoles", roles);
        return "users/formUser";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(Model model, @PathVariable("id") Integer id, RedirectAttributes attributes) {
        User user = usersService.findUserById(id);
        if (user != null) {
            usersService.deleteUser(id);
            attributes.addFlashAttribute("msg", "User data deleted!");
        } else {
            attributes.addFlashAttribute("msg", "User not found!");
        }

        return "redirect:/cusers/list";
    }

}
