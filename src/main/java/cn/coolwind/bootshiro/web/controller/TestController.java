package cn.coolwind.bootshiro.web.controller;

import cn.coolwind.bootshiro.web.service.TestService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("test")
    public Object test(String param) {
        String[] p = param.split(",");
        SimpleHash hash = new SimpleHash("MD5",p[1],ByteSource.Util.bytes(p[0]),2);
        return hash.toString();
    }

    @GetMapping("coolwind")
    public Object coolwind() {
        return "this is coolwind page";
    }

    @GetMapping("aaa")
    public Object aaa() {
        return "this is aaa page";
    }
}
