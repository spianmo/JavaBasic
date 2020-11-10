package org.spianmo.learn.week9.dao.Impl;

import org.spianmo.learn.week9.dao.UserDao;
import org.spianmo.learn.week9.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;

/**
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Author Finger
 * @Date 11/9/2020
 **/
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> selectAllUsers(String username,String passwd) throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM `user` WHERE `username` = '" + username + "' AND `passwd` = '"+ passwd +"';");
        List<User> userList = new ArrayList<>();
        for (Entity entity : entityList) {
            userList.add(castUser(entity));
        }
        return userList;
    }

    private User castUser(Entity entity) {
        User user = new User();
        user.setId(entity.getInt("id"));
        user.setUsername(entity.getStr("username"));
        user.setPasswd(entity.getStr("passwd"));
        user.setNickname(entity.getStr("nickname"));
        user.setOpenid(entity.getStr("openid"));
        user.setSex(entity.getEnum(User.Sex.class,"sex"));
        user.setEmail(entity.getStr("email"));
        user.setNationalid(entity.getStr("nationalid"));
        user.setRegtime(entity.getTimestamp("regtime"));
        user.setLastlogintime(entity.getTimestamp("lastlogintime"));
        return user;
    }

}
