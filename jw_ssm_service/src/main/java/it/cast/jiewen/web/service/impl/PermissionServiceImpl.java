package it.cast.jiewen.web.service.impl;

import it.cast.jiewen.web.dao.PermissionDao;
import it.cast.jiewen.web.domain.Permission;
import it.cast.jiewen.web.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;
    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }
}
