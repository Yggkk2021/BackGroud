package com.ysf.ssm.service.impl;

import com.ysf.ssm.dao.UserDao;
import com.ysf.ssm.entity.User;
import com.ysf.ssm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Create by Tars on 2017/11/18
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User login(User user) {
        return userDao.login( user );
    }

    @Override
    public List<User> findUser(Map<String, Object> map) {
        return userDao.findUser( map );
    }

    @Override
    public long getTotalUser(Map<String, Object> map) {
        return userDao.getTotalUser( map );
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser( user );
    }

    @Override
    public int addUser(User user) {
        if (user.getUsername() == null || user.getPassword() == null || getTotalUser(null) > 90) {
            return 0;
        }
        return userDao.addUser( user );
    }

    @Override
    public int deleteUser(Integer id) {
        return userDao.deleteUser( id );
    }
}
