package com.netlink.servers.service;

import com.netlink.servers.exception.EmployeeIdNotFoundException;
import com.netlink.servers.model.Employee;
import com.netlink.servers.model.Role;
import com.netlink.servers.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public Boolean save(List<Role> role) {
        List<Role> roles = roleRepo.saveAll(role);
        return roles != null;
    }

    @Override
    public List<Role> findAllRoles() {
        return roleRepo.findAll();
    }

    @Override
    public Boolean updateRole(Role role) {
       /* Role role1 = new Role();
        Optional<Role> byId = roleRepo.findById(role.getId());
        List<Employee> employeeList = new ArrayList<>();
        if (byId.isPresent()) {
            Role role2 = byId.get();
            role1.setId(role2.getId());
            role1.setName(role2.getName());
            role1.setDescription(role2.getDescription());
            role1.setStatus(role2.getStatus());
            role1.setEmployeeList(role2.getEmployeeList());
        } else {
            throw new EmployeeIdNotFoundException("No Employee Id Found");
        }
        for (Employee employee : role.getEmployeeList()) {
            employeeList.add(employee);
        }
        role1.setEmployeeList(employeeLis);*/
        Role save = roleRepo.save(role);
        return save != null;
    }
}
