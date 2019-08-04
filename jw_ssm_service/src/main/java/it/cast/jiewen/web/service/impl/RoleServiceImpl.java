package it.cast.jiewen.web.service.impl;

import it.cast.jiewen.web.dao.RoleDao;
import it.cast.jiewen.web.domain.Role;
import it.cast.jiewen.web.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
     private RoleDao roleDao;
    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Role findById(String id) {
        return roleDao.findById(id);
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}
