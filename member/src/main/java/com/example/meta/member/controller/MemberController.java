package com.example.meta.member.controller;

import com.example.meta.member.entity.MemberEntity;
import com.example.meta.member.mapper.MemberMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Component
@RefreshScope
@Controller
@RequestMapping("/meta/member")
@MapperScan("com.example.meta.member.mapper")
public class MemberController {

    @Autowired
    private MemberMapper memberMapper;

    @Value("${meta.user.name}")
    private String name;

    @ResponseBody
    @RequestMapping("test")
    public List<MemberEntity> test(){
        List arrayList  = memberMapper.selectList(null);
        arrayList.forEach(System.out::println);
        return arrayList;
    }

    @ResponseBody
    @RequestMapping("testconfig")
    public String testconfig(){
        return name;
    }
}
