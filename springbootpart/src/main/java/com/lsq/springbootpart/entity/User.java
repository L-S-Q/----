package com.lsq.springbootpart.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data //@JsonIgnore 不展示特定数据
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String sex;
    private String birthday;
    private String idcard;
    private String nation;
    private String address;
}
