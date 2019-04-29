package cn.coolwind.bootshiro.web.service;

import cn.coolwind.bootshiro.web.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
}
