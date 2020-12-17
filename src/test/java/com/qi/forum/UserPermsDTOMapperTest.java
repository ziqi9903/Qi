package com.qi.forum;

import com.qi.forum.dto.UserPermsDTO;
import com.qi.forum.dto.UserRoleDTO;
import com.qi.forum.entity.User;
import com.qi.forum.mapper.UserMapper;
import com.qi.forum.mapper.UserPermsMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ForumApplication.class)
public class UserPermsDTOMapperTest {

    @Autowired
    private com.qi.forum.mapper.UserPermsMapper userPermsMapper;

    @Test
    public void test1(){
        UserPermsDTO userPermsDTO =userPermsMapper.selectPermsByRoleId(1L);
        System.out.println(userPermsDTO);

    }


}
