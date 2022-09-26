package com.netlink.servers.service;

import com.netlink.servers.model.Passport;

import java.util.List;

public interface IPassportService {
    List<Passport> findAllPass();

    Boolean save(Passport passport);
}
