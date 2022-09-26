package com.netlink.servers.service;

import com.netlink.servers.model.Department;

import java.util.List;

public interface IDepartmentService {
    Boolean saveDept(Department department);

    List<Department> findAllData();
}
