package com.qi.forum.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long user_id;
    private Long account_id;
    private String user_name;
    private String user_password;
    private String salt;
    private String token;
    private Long gmt_create;
    private Long gmt_modified;
    private String avatar_url;


    public User(Long account_id, String user_name, String user_password, String token) {
        this.account_id = account_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.token = token;
    }
    public User(Long account_id, String user_name, String user_password, String token, Long gmt_create, Long gmt_modified, String avatar_url) {
        this.account_id = account_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.token = token;
        this.gmt_create = gmt_create;
        this.gmt_modified = gmt_modified;
        this.avatar_url = avatar_url;
    }
}

