package com.netlink.servers.exception;

public class EmailAlreadyExistedException extends RuntimeException{
    public EmailAlreadyExistedException(String s){
        super(s);
    }
}
