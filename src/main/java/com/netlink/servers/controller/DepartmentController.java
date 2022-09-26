package com.netlink.servers.controller;

import com.netlink.servers.model.Department;
import com.netlink.servers.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private IDepartmentService iDepartmentService;

    @PostMapping("/saveDept")
    public ResponseEntity<String> saveDepartment(@RequestBody Department department) {
        ResponseEntity<String> response = null;
        Boolean persist = iDepartmentService.saveDept(department);
        if (persist) {
            response = new ResponseEntity<>("Data saved", HttpStatus.OK);
        } else {
            response = new ResponseEntity<>("Data not saved", HttpStatus.BAD_REQUEST);
        }
        return response;
    }


    @GetMapping("/getData")
    public ResponseEntity<List<Department>> departmentList(){
        ResponseEntity responseEntity = null;
       List<Department> departmentLis = iDepartmentService.findAllData();
       if (departmentLis != null){
           responseEntity = new ResponseEntity(departmentLis,HttpStatus.OK);
       }else {
           responseEntity = new ResponseEntity("No Data present", HttpStatus.OK);
       }
       return responseEntity;
    }

}
