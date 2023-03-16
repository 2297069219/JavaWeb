package com.atguigu.service;

import com.atguigu.pojo.User;

/**
 * ClassName: UserServlce
 * Package: com.atguigu.service.impl
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/13 - 7:26
 * Version: v1.0
 */
public interface UserService {


    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 用户名是否可用
     * @param username
     * @return true可用
     */
    public boolean existsUsername(String username);

}
