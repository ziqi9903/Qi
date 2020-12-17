package com.qi.forum.utils;

import java.util.Random;

public class SaltUtils {

    /**
     * 生成 salt 的静态方法
     */
    public static String getSalt(int n){
        char[] chars ={ 'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P',
                        'Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p',
                        'q','r','s','t','u','v','w','x','y','z','!','~','@','#','$','%','^','&','*','(',')'};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char aChar = chars[new Random().nextInt(chars.length)];
            stringBuilder.append(aChar);
        }
                return stringBuilder.toString();
    }


}
