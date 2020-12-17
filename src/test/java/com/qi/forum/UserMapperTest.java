package com.qi.forum;

import com.qi.forum.dto.UserRoleDTO;
import com.qi.forum.entity.Role;
import com.qi.forum.entity.User;
import com.qi.forum.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ForumApplication.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsertUser(){
        User user = new User(12L,"root","123","123");
        user.setGmt_create(System.currentTimeMillis());
        user.setGmt_modified(user.getGmt_create());

        System.out.println(user);
        userMapper.insertUser(user);
    }

    @Test
    public void testselectByUserName(){
        User user = userMapper.selectByUserName("root");
        System.out.println(user);
    }

    @Test
    public void testSelectByRolesUserName(){
        UserRoleDTO userRoleDTO = userMapper.selectByRolesUserName("ziqi1");
        System.out.println(userRoleDTO);
    }
}
