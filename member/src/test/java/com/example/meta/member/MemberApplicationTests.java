package com.example.meta.member;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.meta.member.entity.MemberEntity;
import com.example.meta.member.mapper.MemberMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class MemberApplicationTests {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    void contextLoads() {
    }

    //添加
    @Test
    public void addMember(){
        MemberEntity member = new MemberEntity();
//        member.setUid("003");
        member.setType(1);
        member.setPassword("dk1dmpoasmdoqdq");
        member.setNick_name("王五");
        member.setAvatar_id(2);
        int rows = memberMapper.insert(member);
        System.out.println("rows:"+rows);
        System.out.println(member);
    }

    //修改
    @Test
    public void updateMember(){
        MemberEntity member = memberMapper.selectById(1);

        member.setUid("00213");
        member.setAvatar_id(24);
        int rows = memberMapper.updateById(member);
        System.out.println("rows:"+rows);
        System.out.println(member);
    }

    //分页
    @Test
    public void pageMember(){
        Page<MemberEntity> page = new Page<>(1,2);
        memberMapper.selectPage(page,null);
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.getTotal());
    }

    @Test
    public void delMemberbyId(){
        int rows = memberMapper.deleteById(1);
        System.out.println("rows:"+rows);
    }

    @Test
    public void delBatchIds(){
        int rows = memberMapper.deleteBatchIds(Arrays.asList(2,3));
        System.out.println("rows:"+rows);
    }
}
