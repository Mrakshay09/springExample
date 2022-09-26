package com.netlink.servers.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorMsg {
    private String msg;
    private String url;
    private LocalDateTime dateTime;
}
