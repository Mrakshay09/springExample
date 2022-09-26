package com.netlink.servers.controller;

import com.netlink.servers.model.Passport;
import com.netlink.servers.model.Role;
import com.netlink.servers.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    IRoleService iRoleService;


    @PostMapping("/saveRole")
    public ResponseEntity<String> saveRole(@RequestBody List<Role> role){
        ResponseEntity<String>  response =null;

        Boolean aBoolean = iRoleService.save(role);
        if (aBoolean){
            response = new ResponseEntity<String>("Data saved", HttpStatus.OK);
        }else {
            response = new ResponseEntity<String>("Can not Save data", HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PutMapping("/updateRole")
    public ResponseEntity<String> saveRole(@RequestBody Role role){
        ResponseEntity<String>  response =null;

        Boolean aBoolean = iRoleService.updateRole(role);
        if (aBoolean){
            response = new ResponseEntity<String>("Data saved", HttpStatus.OK);
        }else {
            response = new ResponseEntity<String>("Can not Save data", HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @GetMapping("/getRole")
    public List<Role> passportList(){
        return iRoleService.findAllRoles();
    }

}
