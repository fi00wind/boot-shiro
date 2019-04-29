package cn.coolwind.bootshiro.web.service;

import cn.coolwind.bootshiro.web.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    private TestMapper testMapper;

    public Object test() {
        return testMapper.selectByPrimaryKey(1);
    }
}
