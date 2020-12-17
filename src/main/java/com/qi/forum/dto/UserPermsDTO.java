package com.qi.forum.dto;

import com.qi.forum.entity.Perms;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserPermsDTO {
    private String role_name;
    private List<Perms> perms;
}
