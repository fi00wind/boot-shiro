# boot-shiro
一个springboot与shiro整合的基础框架

1.实现了其登录功能，密码采用MD5+盐（用户名），散列2次加密

2.实现了权限管理功能：

    a.从数据库里动态地获取权限-->（url,perms[id]）的方式配置权限
    b.通过"/change"，动态地修改权限
