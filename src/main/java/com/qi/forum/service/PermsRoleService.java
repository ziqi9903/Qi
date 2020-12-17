package com.qi.forum.service;

import com.qi.forum.dto.UserPermsDTO;
import com.qi.forum.mapper.UserPermsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermsRoleService {

    @Autowired
    private UserPermsMapper userPermsMapper;

    public UserPermsDTO selectPermsByRoleId(Long id){
        return userPermsMapper.selectPermsByRoleId(id);
    }
}
