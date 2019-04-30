package cn.coolwind.bootshiro.core.config.shiro;

import cn.coolwind.bootshiro.web.dao.UserDao;
import cn.coolwind.bootshiro.web.entity.Permission;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShiroService {

    @Autowired
    private UserDao userDao;

    public Map<String, String> initFilterChain() {
        //拦截器.
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 配置不会被拦截的链接 顺序判断
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/login", "anon");
        List<Permission> permissions = userDao.getAllPermission();
        for (Permission permission : permissions) {
            filterChainDefinitionMap.put(permission.getUrl(), "perms[" + permission.getId() + "]");
        }
        //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/**", "authc");
        return filterChainDefinitionMap;
    }
}
