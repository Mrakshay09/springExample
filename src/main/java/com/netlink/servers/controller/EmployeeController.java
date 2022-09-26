package com.netlink.servers.controller;

import com.netlink.servers.exception.EmployeeIdNotFoundException;
import com.netlink.servers.model.Employee;
import com.netlink.servers.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emp")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;


    @GetMapping("/hello")
    public ResponseEntity<String> getHelloMsg() {
        String hello = "Hello Netlinker";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("employee", "Employee managements");

        return new ResponseEntity<>(hello, httpHeaders, HttpStatus.OK);
    }

    // Save data to database // localhost:9099/saveEmployee
    @PostMapping("/saveEmplpoyee") // C
    public Boolean saveEmployeeInfo(@RequestBody Employee employee) {
        return iEmployeeService.saveEmployee(employee);
    }

    // getting All Object
    @GetMapping("/getEmployee") // R
    public ResponseEntity<List<Employee>> findAllListOfEmp() {
        ResponseEntity responseEntity = null;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("employee", "Employee managements");
        List<Employee> allEmp = iEmployeeService.findAllEmp();
        if (allEmp!= null){
            return ResponseEntity.status(HttpStatus.OK).header(httpHeaders.toString()).body(allEmp);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/getEmployeeById/{id}")
    public Employee findByEmpID(@PathVariable Long id) {
        Optional<Employee> employeeById1 = iEmployeeService.findEmpById(id);
        if (employeeById1.isPresent()) {
            return iEmployeeService.findEmployeeById(id);
        } else {
            throw new EmployeeIdNotFoundException("employeeById");
        }
    }


    @PostMapping("/updateEmployee") //u
    public Boolean updateEmployeeInfo(@RequestBody Employee employee) {
        return iEmployeeService.updateEmployee(employee);
    }

    @DeleteMapping("/deleteById/{id}") //d
    public String deleteById(@PathVariable Long id) {
        Optional<Employee> employeeById = iEmployeeService.findEmpById(id);
        return iEmployeeService.deleteEmp(id);
    }

    @GetMapping("getByName/{name}")
    public Employee getByNameOrID(@PathVariable String name) {
        Employee byNameOrId = iEmployeeService.findByNameOrId(name);
        return byNameOrId;
    }

    @GetMapping("getByStatus/{status}")
    public List<Employee> getByStatus(@PathVariable Boolean status) {
        List<Employee> byStatus = iEmployeeService.findByStatus(status);
        return byStatus;
    }

    @GetMapping("getByNameOrDept/{name}/{dept}")
    public List<Employee> getByStatus(@PathVariable String name,
                                      @PathVariable String dept) {
        List<Employee> byNameOrDept = iEmployeeService.findByNameOrDept(name, dept);
        return byNameOrDept;
    }

    @GetMapping("getBySalary/{salary}")
    public List<Employee> getBySalary(@PathVariable Integer salary) {
        List<Employee> byNameOrDept = iEmployeeService.findByEmployeeSalary(salary);
        return byNameOrDept;
    }

    @GetMapping("getByDesgAndDept")
    public List<Employee> getByDesgAndDept(@RequestParam("dept") String dept,
                                           @RequestParam("desg") String desg) {
        List<Employee> byEmployeeDesgAndDept = iEmployeeService.findByEmployeeDesgAndDept(dept, desg);
        return byEmployeeDesgAndDept;
    }

    @PutMapping("/updateData")
    public Employee updateEmpInfo(@RequestBody Employee employee) {
        Employee employee1 = iEmployeeService.updateEmpInfo(employee);
        return employee1;
    }
}
