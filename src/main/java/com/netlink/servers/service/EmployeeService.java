package com.netlink.servers.service;

import com.netlink.servers.exception.EmailAlreadyExistedException;
import com.netlink.servers.exception.EmployeeIdNotFoundException;
import com.netlink.servers.model.Employee;
import com.netlink.servers.model.Role;
import com.netlink.servers.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Boolean saveEmployee(Employee employee) {
        if (employee.getId() != null) {
            employee.setId(employee.getId());
        }
        Employee byEmail = employeeRepository.findByEmail(employee.getEmail());
        if (byEmail != null) {
            throw new EmailAlreadyExistedException("Email Already Existed");
        }

        Employee save = employeeRepository.save(employee);
        return save != null;
    }

    @Override
    public List<Employee> findAllEmp() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Boolean updateEmployee(Employee employee) {
        Employee save = null;
        Optional<Employee> empById = findEmpById(employee.getId());
        List<Role> roleList = new ArrayList<>();
       /* if (employee.getEmail() != null) {
            Employee byEmail = employeeRepository.findByEmail(employee.getEmail());
            if (byEmail!= null) {
                throw new EmailAlreadyExistedException("Email already existed");
            }
        }*/
        if (empById.isPresent()) {
            Employee employee1 = empById.get();
            employee1.setId(employee.getId()); // IMPORTANT LINE
            employee1.setName(employee.getName());
            employee1.setEmail(employee.getEmail());
            employee1.setDept(employee.getDept());
            employee1.setGender(employee.getGender());
            employee1.setStatus(employee.getStatus());
            employee1.setDateOfBirth(employee.getDateOfBirth());
//            roleList.addAll(employee.getRoleList());
//            employee1.setRoleList(roleList);
            save = employeeRepository.save(employee1);
        }
        return save != null;
    }

    public Optional<Employee> findEmpById(Long id) {
        Optional<Employee> byId = employeeRepository.findById(id);
        return byId;
    }

    @Override
    public String deleteEmp(Long id) {
        Optional<Employee> empById = getEmpById(id);
        employeeRepository.deleteById(id);
        return ("Employee with id " + id + " Deleted");
    }

    public Optional<Employee> getEmpById(Long id){
        Optional<Employee> byId = employeeRepository.findById(id);
        if (!byId.isPresent()){
            throw new EmployeeIdNotFoundException("Employee Id Not Found ");
        }
        return byId;
    }


    @Override
    public Employee findByNameOrId(String name) {
        Employee byName = employeeRepository.findByName(name);
        if (byName != null) {
            return byName;
        } else {
            throw new RuntimeException("No Data");
        }
    }

    @Override
    public List<Employee> findByStatus(Boolean status) {
        List<Employee> byStatus = employeeRepository.findByStatus(status);
        return byStatus;
    }

    @Override
    public List<Employee> findByNameOrDept(String name, String dept) {
        List<Employee> byNameOrDept = employeeRepository.findByNameAndDept(name, dept);
        return byNameOrDept;
    }

    @Override
    public List<Employee> findByEmployeeSalary(Integer salary) {
        List<Employee> byEmployeeSalary = employeeRepository.findByEmployeeSalary(salary);
        return byEmployeeSalary;
    }

    @Override
    public List<Employee> findByEmployeeDesgAndDept(String dept, String desg) {
        List<Employee> byEmpDesignationOrDept = employeeRepository.findByEmpDesignationOrDept(desg, dept);
        return byEmpDesignationOrDept;
    }

    @Override
    public Employee updateEmpInfo(Employee employee) {
        Optional<Employee> byId = employeeRepository.findById(employee.getId());
        if (!byId.isPresent()){
            throw new EmployeeIdNotFoundException("EmployeeIdNotFoundException");
        }

        Employee employee1 = byId.get();
        employee1.setDesignation(employee.getDesignation());
        Employee save = employeeRepository.save(employee1);
        return save;
    }



}
