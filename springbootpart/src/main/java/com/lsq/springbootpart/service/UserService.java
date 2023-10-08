package com.lsq.springbootpart.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lsq.springbootpart.entity.User;

public interface UserService extends IService<User> {
    boolean saveUser(User user);
}
