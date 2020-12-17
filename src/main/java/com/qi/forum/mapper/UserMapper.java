package com.qi.forum.mapper;

import com.qi.forum.dto.UserRoleDTO;
import com.qi.forum.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface UserMapper {

    void insertUser(User user);

    User findByToken(@Param(value = "token") String token);

    User findByUserId(Long creator);

    User selectByUserName(String username);

    UserRoleDTO selectByRolesUserName(String username);

}
