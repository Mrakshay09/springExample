package com.netlink.servers.exception;

public class EmployeeIdNotFoundException extends RuntimeException{
    public EmployeeIdNotFoundException(String s){
        super(s);
    }
}
