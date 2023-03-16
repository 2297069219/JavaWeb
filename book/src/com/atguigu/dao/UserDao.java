package com.atguigu.dao;

import com.atguigu.pojo.User;

/**
 * ClassName: UserDao
 * Package: com.atguigu.dao.impl
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/12 - 21:03
 * Version: v1.0
 */
public interface UserDao {


    /**
     * queryByUsername
     * @param username username
     * @return exists
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码
     * @param username
     * @param password
     * @return  null 不存在
     */
    public User queryUserByUsernameAndPassword(String username,String password);
    /**
     * sava
     * @param user user
     * @return     -1表示失败 其他sql影响的行数
     */
    public int saveUser(User user);

}
