package com.qi.forum.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.qi.forum.shiro.realms.CustomerReamls;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 用来整合 Shiro 框架相关配置类
 */
@Configuration
public class ShiroConfig {
/**
 * 1 . 创建 ShiroFilter 拦截器
 *  拦截所有网页请求
 *  完成认证和权限控制
 */
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //给 filter 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        /**
         * 配置系统受限资源
         * 配置系统公共资源 qi
         * authc 请求这个资源需要认证和授权
         * anon : 无需认证就可以访问
         * authc :必须认真了才能访问
         * user : 必须拥有记住我功能才能用
         * perms : 拥有对某个资源的权限才能访问
         * role : 拥有某个角色权限才能访问
         */
        Map<String,String> map = new LinkedHashMap<>();
        map.put("/register","anon");
        map.put("/toRegister","anon");
        map.put("/login","anon");   //yml配置白名单
        map.put("/logout","anon");   //yml配置白名单


        map.put("/*","authc");
        /**
         * 设置 url 路径没有通过认证跳转路径
         */
        shiroFilterFactoryBean.setLoginUrl("/login");
        /**
         * 将 配置路径和权限放入
         */
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }
    /**
     *  2 . 创建安全管理器
     *  Qualifier 指定关联对象
     */
    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier(value = "customerReamls") Realm realm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //给安全管理器设置 realm
        //关联 getRealm
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }
    /**
     *  3 . 创建自定义 realm
     *  创建 realm 对象 , 自定义 Realm 类
     */
    @Bean(name = "customerReamls")
    public Realm getRealm(){
        CustomerReamls customerReamls = new CustomerReamls();
        //修改凭证校验器
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        //设置散列次数
        credentialsMatcher.setHashIterations(1024);
        customerReamls.setCredentialsMatcher(credentialsMatcher);
        return customerReamls;
    }
    /**
     * 整合 Shiro Dialect : 用来集合 Shiro thymeleaf
     */
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
