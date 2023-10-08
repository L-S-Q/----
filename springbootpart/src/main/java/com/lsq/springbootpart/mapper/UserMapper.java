package com.lsq.springbootpart.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lsq.springbootpart.entity.User;

//@Mapper
public interface UserMapper extends BaseMapper<User> {
//    @Select("select * from user")
//    List<User> finAll();
//
//    @Insert("insert into user(name,sex,birthday,id_card,nation,address) values(#{name},#{sex},#{birthday},#{id_card},#{nation},#{address})")
//    int insert(User user);
//
//    int update(User user);

//    @Delete("delete from user where id=#{id}")
//    Integer deleteById(@Param("id") Integer id);

//    @Select("select * from user where name like #{name} limit #{pageNum},#{pageSize}")
//    List<User> selectPage(@Param("pageNum") Integer pageNum,
//                          @Param("pageSize") Integer pageSize,
//                          @Param("name") String name);

//    @Select("select count(*) from user where name like concat('%',#{name},'%')")
//    Integer selectTotal(String name);
}
