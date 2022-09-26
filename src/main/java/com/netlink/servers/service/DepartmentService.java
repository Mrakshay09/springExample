package com.netlink.servers.service;

import com.netlink.servers.exception.EmployeeIdNotFoundException;
import com.netlink.servers.model.Department;
import com.netlink.servers.model.Employee;
import com.netlink.servers.repository.DepartmentRepo;
import com.netlink.servers.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Boolean saveDept(Department department) {
        Employee save1 = null;
        Department department1 = new Department();
        if (department.getId() != null) {
            department1.setId(department.getId());
        }
        department1.setDepName(department.getDepName());
        Department save = departmentRepo.save(department1);
        for (Employee employee : department.getEmployeeList()) {
            Optional<Employee> byId = employeeRepository.findById(employee.getId());
            if (byId.isPresent()) {
                Employee employee1 = byId.get();
                employee1.setDepartment(save);
                save1 = employeeRepository.save(employee1);
            } else {
                throw new EmployeeIdNotFoundException("  Employee id not found");
            }
        }
        return (save != null && save1 != null);
    }

    @Override
    public List<Department> findAllData() {
        return departmentRepo.findAll();
    }
}
