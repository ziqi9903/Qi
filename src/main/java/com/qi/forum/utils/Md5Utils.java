package com.qi.forum.utils;

import com.qi.forum.entity.User;
import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5Utils {

    public String Md5(User user){
        /**
         * 处理业务调用
         * 明文密码进行 MD5 + salt + hash 散列
         */
        Md5Hash md5Hash = new Md5Hash(user.getUser_password(),user.getSalt(),1024);

        return null;
    }
}
