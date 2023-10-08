package com.lsq.springbootpart.controller;

import com.lsq.springbootpart.entity.Administrator;
import com.lsq.springbootpart.service.impl.AdministratorServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/login")
public class AdministratorController {
    @Resource
    private AdministratorServiceImpl administratorServiceImpl;

    @PostMapping
    public boolean login(@RequestBody Administrator administrator) {
        String username = administrator.getUsername();
        String password = administrator.getPassword();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return false;
        }
        return administratorServiceImpl.login(administrator);
    }

    @PostMapping("/register")
    public boolean register(@RequestBody Administrator administrator) {
        System.out.println("administrator = " + administrator);
        return administratorServiceImpl.saveAdministrator(administrator);
    }
}
