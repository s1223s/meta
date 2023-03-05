package com.example.meta.member;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.meta.member.entity.MemberEntity;
import com.example.meta.member.mapper.MemberMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class QueryTestDemo {

    @Autowired
    private MemberMapper mapper;

    @Test
    public void query1(){
        QueryWrapper<MemberEntity> wrapper = new QueryWrapper<>();
        /*
        * ge  大于等于
        * gt  大于
        * le  小于等于
        * lt  小于
        * eq  等于
        * ne  不等于
        * like 模糊
        * likeLeft 左包含
        * likeRight 右包含
        */
        wrapper.ge("avatar_id",1);
        //排序
//        wrapper.orderByAsc("id");
        wrapper.orderByDesc("id");
        List<MemberEntity> list = mapper.selectList(wrapper);
        System.out.println(list);
    }
}
