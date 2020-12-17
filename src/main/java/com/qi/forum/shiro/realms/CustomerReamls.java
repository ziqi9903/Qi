package com.qi.forum.shiro.realms;


import com.qi.forum.dto.UserPermsDTO;
import com.qi.forum.dto.UserRoleDTO;
import com.qi.forum.entity.Perms;
import com.qi.forum.entity.Role;
import com.qi.forum.entity.User;
import com.qi.forum.service.PermsRoleService;
import com.qi.forum.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import sun.text.CollatorUtilities;

import java.util.List;


/**
 * 自定义 Realm extends AuthorizingRealm
 *
 * doGetAuthorizationInfo 实现授权操作
 * doGetAuthenticationInfo 实现认证操作
 */

public class CustomerReamls extends AuthorizingRealm {
    
    @Autowired
    private UserService userService;

    @Autowired
    private PermsRoleService permsRoleService;
    
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
       //获取身份信息
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        //根据主身份信息获取 角色 和 权限信息
        UserRoleDTO roleList = userService.findRolesByUserName(primaryPrincipal);
        if(!CollectionUtils.isEmpty(roleList.getRoleList())){
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            List<Role> list = roleList.getRoleList();
            list.forEach(role -> {
                simpleAuthorizationInfo.addRole(role.getRole_name());

            //权限信息
            UserPermsDTO userPermsDTO =permsRoleService.selectPermsByRoleId(role.getRole_id());
            List<Perms> permsList = userPermsDTO.getPerms();
            if (!CollectionUtils.isEmpty(permsList)){
                permsList.forEach(perm -> {
                    simpleAuthorizationInfo.addStringPermission(perm.getName());
                });
            }
        });
            return simpleAuthorizationInfo;
            }

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        User user = userService.selectByUserName(userToken.getUsername());
        if(!ObjectUtils.isEmpty(user)){
            return new SimpleAuthenticationInfo(user.getUser_name(),user.getUser_password(), ByteSource.Util.bytes(user.getSalt()),this.getName());
        }
        return null;
    }
}
