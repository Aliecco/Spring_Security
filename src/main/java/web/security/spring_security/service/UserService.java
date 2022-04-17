package web.security.spring_security.service;

import web.security.spring_security.model.User;

import java.util.List;

public interface UserService {
    User findById(Long id);

    User findByEmail(String email);

    List<User> findAll();

    void saveUser(User user);

    void deleteById(Long id);

    void updateUser(User user);
}