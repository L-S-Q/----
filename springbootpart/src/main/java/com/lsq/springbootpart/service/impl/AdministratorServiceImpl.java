package com.lsq.springbootpart.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lsq.springbootpart.entity.Administrator;
import com.lsq.springbootpart.mapper.AdministratorMapper;
import com.lsq.springbootpart.service.AdministratorService;
import org.springframework.stereotype.Service;


@Service
public class AdministratorServiceImpl extends ServiceImpl<AdministratorMapper, Administrator>
    implements AdministratorService{

    @Override
    public boolean login(Administrator administrator) {
        QueryWrapper<Administrator> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",administrator.getUsername());
        queryWrapper.eq("password",administrator.getPassword());
        Administrator one = getOne(queryWrapper);
        return one != null;
    }

    @Override
    public boolean saveAdministrator(Administrator administrator) {
        return saveOrUpdate(administrator);
    }
}