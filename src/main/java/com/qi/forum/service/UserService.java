package com.qi.forum.service;

import com.qi.forum.dto.UserRoleDTO;
import com.qi.forum.entity.Role;
import com.qi.forum.entity.User;
import com.qi.forum.mapper.UserMapper;
import com.qi.forum.utils.SaltUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserMapper userMapper;

    public UserRoleDTO findRolesByUserName(String username){
        return userMapper.selectByRolesUserName(username);
    }


    public void InsertUser(User user){
        /**
         * 处理业务生成
         * 1 . 生成随机盐
         * 2 . 将随即盐保存入数据
         * 3 . 明文密码进行 md5 + salt + hash
         */
        String salt = SaltUtils.getSalt(6);
        user.setSalt(salt);
        Md5Hash md5Hash = new Md5Hash(user.getUser_password(),salt,1024);

        user.setUser_password(md5Hash.toHex());

        user.setGmt_create(System.currentTimeMillis());
        user.setGmt_modified(user.getGmt_create());

        System.out.println(user);
        userMapper.insertUser(user);
    }


    public User selectByUserName(String username) {
        User user = userMapper.selectByUserName(username);
        return user;
    }

}
