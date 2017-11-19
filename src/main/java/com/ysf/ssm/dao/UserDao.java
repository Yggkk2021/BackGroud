package com.ysf.ssm.dao;

import com.ysf.ssm.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Create by Tars on 2017/11/18
 */
@Repository
public interface UserDao {

    /**
     * 登录
     *
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 查找用户列表
     *
     * @param map
     * @return
     */
    public List<User> findUser(Map<String,Object> map);

    /**
     * @param map
     * @return
     */
    public long getTotalUser(Map<String, Object> map);

    /**
     * 更新
     *
     * @param user
     * @return
     */
    public int updateUser(User user);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    public int deleteUser(Integer id);
}
