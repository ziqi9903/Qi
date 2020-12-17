package com.qi.forum.service;

import com.qi.forum.entity.User;
import com.qi.forum.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private UserMapper userMapper;

    public void register(User user){
        /**
         * 处理业务调用
         */
    }
}
