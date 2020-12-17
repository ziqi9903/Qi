package com.qi.forum.dto;

import com.qi.forum.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserRoleDTO {
    private Long user_id;
    private String user_name;

    private List<Role> roleList;

}
