package com.example.meta.member.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("arc_member")
public class MemberEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String unionid;
    private String cover;
    private String password;
    private String nick_name;
    private String phone;
    private Integer gender;
    private String address;
    private String profile;
    private String lastip;
    private Date lasttime;
    private String openid;
    private Integer type;
    private Integer avatar_id;
    private String uid;
    @TableLogic
    private Integer is_delete;


}
