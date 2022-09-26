package com.netlink.servers.service;

import com.netlink.servers.model.Passport;
import com.netlink.servers.repository.PassportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassportService implements IPassportService{

    @Autowired
    private PassportRepo passportRepo;

    @Override
    public List<Passport> findAllPass() {
        return passportRepo.findAll();
    }

    @Override
    public Boolean save(Passport passport) {
        Passport save = passportRepo.save(passport);
        return save!=null;
    }
}
