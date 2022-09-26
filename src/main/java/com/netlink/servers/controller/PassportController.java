package com.netlink.servers.controller;

import com.netlink.servers.model.Passport;
import com.netlink.servers.service.IPassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PassportController {

    @Autowired
    private IPassportService iPassportService;

    @GetMapping("/getPass")
    public List<Passport> passportList(){
        return iPassportService.findAllPass();
    }

    @PostMapping("/savePass")
    public ResponseEntity<String> savePassData(@RequestBody Passport passport){
        ResponseEntity<String>  response =null;

       Boolean aBoolean = iPassportService.save(passport);
       if (aBoolean){
           response = new ResponseEntity<String>("Data saved", HttpStatus.OK);
        }else {
           response = new ResponseEntity<String>("Can not Save data", HttpStatus.BAD_REQUEST);
       }
       return response;
    }

}
