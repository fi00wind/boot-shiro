package cn.coolwind.bootshiro.web.dao;

import cn.coolwind.bootshiro.web.entity.User;

public interface UserDao {
    User getByUsername(String username);
}
