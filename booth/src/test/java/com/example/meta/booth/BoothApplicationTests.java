package com.example.meta.booth;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
class BoothApplicationTests {

    @Test
    void contextLoads() {
        FastAutoGenerator.create("jdbc:mysql://120.25.152.17:3306/arc_meta", "root", "qinjiajun1103")
                .globalConfig(builder -> {
                    builder.author("archillec") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("E://java//jx//code"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example.meta.booth") // 设置父包名
                            .controller("controller") //生成controller层
                            .entity("entity") //生成实体层
                            .service("service") //生成服务层
                            .mapper("mapper") //生成mapper层
//                            .moduleName("meta") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "E://java//jx//code")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("arc_booth","arc_booth_admin") // 设置需要生成的表名
                            .addTablePrefix("arc_") // 设置过滤表前缀
                            .entityBuilder() //开启实体类配置
                            .enableLombok(); //开启lombok
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
