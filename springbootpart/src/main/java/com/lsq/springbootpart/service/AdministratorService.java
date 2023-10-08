package com.lsq.springbootpart.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lsq.springbootpart.entity.Administrator;

public interface AdministratorService extends IService<Administrator> {

    boolean login(Administrator administrator);

    boolean saveAdministrator(Administrator administrator);
}
