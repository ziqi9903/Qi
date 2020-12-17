package com.qi.forum.mapper;

import com.qi.forum.dto.UserPermsDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserPermsMapper {

    UserPermsDTO selectPermsByRoleId(Long id);

}
