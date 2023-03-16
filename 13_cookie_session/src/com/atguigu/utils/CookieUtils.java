package com.atguigu.utils;

import javax.servlet.http.Cookie;

/**
 * ClassName: CookieUtils
 * Package: com.atguigu.utils
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/16 - 18:51
 * Version: v1.0
 */
public class CookieUtils {

    public static Cookie findCookie(String name,Cookie[] cookies){
        if(name==null||cookies==null||cookies.length==0){
            return null;
        }
        for (Cookie cookie : cookies) {
            if(name.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }

}
