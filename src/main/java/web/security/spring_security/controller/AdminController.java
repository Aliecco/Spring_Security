package web.security.spring_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.security.spring_security.model.User;
import web.security.spring_security.service.RoleService;
import web.security.spring_security.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService service;
    @Autowired
    private RoleService roleService;

    @GetMapping
    public String index(Principal principal,
                        Model model) {
        User user = service.findByEmail(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("users", service.findAll());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", service.findById(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("roles", roleService.getAllRoles());
        return "users/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user, @RequestParam(value = "roles") String[] roles) {
        user.setRoles(roleService.getSetOfRoles(roles));
        service.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", service.findById(id));
        return "users/edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@ModelAttribute("user") User user,
                         @RequestParam(value = "roles", required = false) String[] roles) {

        user.setRoles(roleService.getSetOfRoles(roles));
        service.updateUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.deleteById(id);
        return "redirect:/admin";
    }
}
