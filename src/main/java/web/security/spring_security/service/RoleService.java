package web.security.spring_security.service;

import web.security.spring_security.model.Role;

import java.util.HashSet;
import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    Role getById(int id);

    Role getRoleByName(String name);

    HashSet<Role> getSetOfRoles(String[] roleNames);

    void addRole(Role role);
}
