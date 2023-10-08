package com.lsq.springbootpart.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.lsq.springbootpart.entity.User;
import com.lsq.springbootpart.mapper.UserMapper;
import com.lsq.springbootpart.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User>
        implements UserService {

    @Override
    public boolean saveUser(User user) {
//        if (String.valueOf(user.getId()).equals("")){
//            return save(user);//mybatisplus提供的方法
//        }else {
//            return updateById(user);
//        }
        return saveOrUpdate(user);
    }



//    @Autowired
//    private UserMapper userMapper;

//    public int save(User user) {
//        if ( String.valueOf(user.getId()).equals("")) {//String.valueOf(in).equals("")
//            return userMapper.insert(user);
//        } else {
//            return userMapper.update(user);
//        }
//    }

//    public Integer deleteById(User user) {
//        return userMapper.deleteById(user.getId());
//    }


}
