package web.security.spring_security.dao;

import web.security.spring_security.model.User;

import java.util.List;

public interface UserDao {

    void updateUser(User user);

    List<User> findAll();

    User getById(Long id);

    User getByEmail(String email);

    void save(User user);

    void deleteById(Long id);
}