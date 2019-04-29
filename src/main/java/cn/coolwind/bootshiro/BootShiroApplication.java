package cn.coolwind.bootshiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"cn.coolwind.bootshiro.web.mapper","cn.coolwind.bootshiro.web.dao"})
public class BootShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootShiroApplication.class, args);
    }

}
