package com.netlink.servers.service;

import com.netlink.servers.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Boolean saveEmployee(Employee employee);

    List<Employee> findAllEmp();

    Employee findEmployeeById(Long id);

    Boolean updateEmployee(Employee employee);

    String deleteEmp(Long id);

    public Optional<Employee> findEmpById(Long id);

    Employee findByNameOrId(String name);

    List<Employee> findByStatus(Boolean status);

    List<Employee> findByNameOrDept(String name, String dept);

    List<Employee> findByEmployeeSalary(Integer salary);

    List<Employee> findByEmployeeDesgAndDept(String dept, String desg);

    Employee updateEmpInfo(Employee employee);
}
