package com.qi.forum.service;


import com.qi.forum.dto.UserConDTO;
import com.qi.forum.entity.User;
import com.qi.forum.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserConService {

    @Autowired
    private UserMapper userMapper;

    public UserConDTO list(Integer page, Integer size) {
        UserConDTO userConDTO = new UserConDTO();

            /**
             * page : 页数 第几页
             * offset  size * (page - 1) 当前页码 ?
             * index
             *   页数   all / size
             *
             *   totalCount 总个数
             *   TotalPage 总页数
             */
            Integer offset = size * (page - 1);

            Integer totalCount = userMapper.count();

            if(totalCount % size == 0){
                userConDTO.setTotalPage(totalCount / size);
            }else{
                userConDTO.setTotalPage(totalCount / size + 1);
            }

            if(offset < 1){
                offset = 1;
            }
            if(offset > userConDTO.getTotalPage()){
                offset = userConDTO.getTotalPage();
            }

            List<User> userList = userMapper.list(offset, size);

            userConDTO.setUsers(userList);
            userConDTO.setPagination(page,size);


        return userConDTO;
    }
}
