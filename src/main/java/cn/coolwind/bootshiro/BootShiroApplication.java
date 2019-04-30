package cn.coolwind.bootshiro;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"cn.coolwind.bootshiro.web.mapper","cn.coolwind.bootshiro.web.dao"})
public class BootShiroApplication {
    private static Logger log = LoggerFactory.getLogger(BootShiroApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BootShiroApplication.class, args);
        log.info("###########################系统启动成功！！！");
    }

}
