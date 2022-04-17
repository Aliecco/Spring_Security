package web.security.spring_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import web.security.spring_security.model.Role;
import web.security.spring_security.model.User;
import web.security.spring_security.service.RoleService;
import web.security.spring_security.service.UserService;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {


        ApplicationContext context = SpringApplication.run(SpringSecurityApplication.class, args);


//        UserService service = context.getBean(UserService.class);
//        RoleService roleService = context.getBean(RoleService.class);
//
//        Role role1 = new Role("USER");
//        Role role2 = new Role("ADMIN");
//        roleService.addRole(role1);
//        roleService.addRole(role2);
//
//
//        List<Role> roles1 = new ArrayList<>();
//
//        roles1.add(role1);
//        User user1 = new User("user", "user", "User", "Userov", 21);
//        user1.setRoles(roles1);
//        service.saveUser(user1);
//
//        List<Role> roles2 = new ArrayList<>();
//        roles2.add(role2);
//        User user2 = new User("admin", "admin", "Admin", "Adminov",23);
//        user2.setRoles(roles2);
//        service.saveUser(user2);
    }
}
