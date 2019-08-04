package it.cast.jiewen.web.service;

import it.cast.jiewen.web.domain.Role;

import java.util.List;

public interface RoleService {

    public List<Role> findAll();

    public Role findById(String id);

    void save(Role role);
}
