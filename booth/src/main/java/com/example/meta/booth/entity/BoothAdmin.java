package com.example.meta.booth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author archillec
 * @since 2023-03-05
 */
@Getter
@Setter
@TableName("arc_booth_admin")
@ApiModel(value = "BoothAdmin对象", description = "")
public class BoothAdmin implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String unionid;

    private String avatarUrl;

    private String password;

    private String name;

    private String phone;

    @ApiModelProperty("性别 0：未知、1：男、2：女")
    private Boolean gender;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("个人简介")
    private String profile;

    private String lastip;

    private LocalDateTime lasttime;

    private String salt;

    private String openid;

    private Boolean type;

    private LocalDateTime addTime;

    private Integer auditAdminId;

    private Boolean state;

    private String auditNotes;

    private LocalDateTime auditTime;

    private Boolean businessType;

    private String certificateNum;

    private Boolean certificateType;

    private String certificateUrl;

    private String contact;

    private String email;

    private String tel;

    private Boolean boothType;

    @ApiModelProperty("1-展商、2-店铺")
    private Boolean showType;

    private Boolean shopState;

    private String shopNotes;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
