package com.netlink.servers.service;

import com.netlink.servers.model.Role;

import java.util.List;

public interface IRoleService {
    Boolean save(List<Role> role);

    List<Role> findAllRoles();

    Boolean updateRole(Role role);
}
