package com.netlink.servers.repository;

import com.netlink.servers.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // How to create custom method on repository
    Employee findByName(String name);

    List<Employee> findByStatus(Boolean status);

    // select * from employe where name = "" or dept = ""
    List<Employee> findByNameOrDept(String name, String dept);

    // select * from employe where name = "" And dept = ""
    List<Employee> findByNameAndDept(String name, String dept);

    // Create a custom query and get data from that query
    @Query(value = "select * from master.employee_tbl e where e.salary > ?1", nativeQuery = true)
    public List<Employee> findByEmployeeSalary(Integer salary);

    @Query(value = "select * from master.employee_tbl e where e.designation = ?1 and e.department = ?2  ", nativeQuery = true)
    List<Employee> findByEmpDesignationOrDept(String desg, String dept);


    Employee findByEmail(String email);
}
