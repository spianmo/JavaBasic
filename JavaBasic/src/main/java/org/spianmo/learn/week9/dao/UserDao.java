package org.spianmo.learn.week9.dao;

import org.spianmo.learn.week9.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author Finger
 * @Date 11/9/2020
 **/
public interface UserDao {
    /**
     * 查询用户
     *
     * @return
     */
    List<User> selectAllUsers(String username,String passwd) throws SQLException;
}
