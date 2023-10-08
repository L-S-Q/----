package com.lsq.springbootpart.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.lsq.springbootpart.entity.User;
import com.lsq.springbootpart.service.impl.UserServiceImpl;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserServiceImpl userServiceImpl;

    @PostMapping
    public boolean save(@RequestBody User user) {
        return userServiceImpl.saveUser(user);
    }

    @GetMapping
    public List<User> findAll() {
        return userServiceImpl.list();
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return userServiceImpl.removeById(id);
    }

    //分页查询
//    @GetMapping("/page")
//    //@RequestParam  接收 ?pageNum=1&pageSize=10
//    public Map<String,Object> findPage(@RequestParam Integer pageNum,
//                                       @RequestParam Integer pageSize,
//                                       @RequestParam String name) {
//        pageNum = (pageNum - 1) * pageSize;
//        name="%"+name+"%";
//        List<User> data = userMapper.selectPage(pageNum, pageSize,name);
//        Integer total = userMapper.selectTotal(name);
//        Map<String,Object> res =new HashMap<>();
//        res.put("data",data);
//        res.put("total",total);
//        return res;
//    }

    //
    @GetMapping("/page")
    //@RequestParam  接收 ?pageNum=1&pageSize=10
    public IPage<User> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                                @RequestParam(defaultValue = "") String name,
                                @RequestParam(defaultValue = "") String idcard,
                                @RequestParam(defaultValue = "") String address) {
        IPage<User> page = new Page<>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (!"".equals(name)) {
            queryWrapper.like("name", name);
        }
        if (!"".equals(idcard)) {
            queryWrapper.like("idcard", idcard);
        }
        if (!"".equals(address)) {
            queryWrapper.like("address", address);
        }
        return userServiceImpl.page(page, queryWrapper);//null
    }
}
