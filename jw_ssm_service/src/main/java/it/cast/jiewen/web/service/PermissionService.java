package it.cast.jiewen.web.service;

import it.cast.jiewen.web.domain.Permission;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PermissionService {
    public List<Permission> findAll() throws Exception;

    void save(Permission permission);
}
