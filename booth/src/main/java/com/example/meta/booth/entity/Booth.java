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
@TableName("arc_booth")
@ApiModel(value = "Booth对象", description = "")
public class Booth implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String cover;

    private String usePeriod;

    private String company;

    private Boolean type;

    private String jsonUrl;

    private LocalDateTime addTime;

    private Integer boothResourcesId;

    private String placeId;

    private Integer templateId;

    private Boolean isUse;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
