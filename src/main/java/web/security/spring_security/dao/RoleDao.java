package web.security.spring_security.dao;


import web.security.spring_security.model.Role;

import java.util.HashSet;
import java.util.List;

public interface RoleDao {
    List<Role> getAllRoles();

    Role getRoleByName(String name);

    HashSet<Role> getSetOfRoles(String[] roleNames);

    void add(Role role);

    void edit(Role role);

    Role getById(int id);
}
