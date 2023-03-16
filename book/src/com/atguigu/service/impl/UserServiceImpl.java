package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;

/**
 * ClassName: UserServiceimpl
 * Package: com.atguigu.service.impl
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/13 - 7:31
 * Version: v1.0
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao=new UserDaoImpl();


    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if(userDao.queryUserByUsername(username)==null){
            //null 可用
            return false;
        }
        return true;
    }
}
