package org.spianmo.learn.week9.service.Impl;

import org.spianmo.learn.week9.dao.UserDao;
import org.spianmo.learn.week9.entity.User;
import org.spianmo.learn.week9.service.Impl.callback.OnLoginCallback;
import org.spianmo.learn.week9.service.LoginService;
import org.spianmo.learn.week9.utils.DaoFactory;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName LoginServiceImpl
 * @Description TODO
 * @Author Finger
 * @Date 11/9/2020
 **/
public class LoginServiceImpl implements LoginService {
    private final UserDao userDao = DaoFactory.getUserDaoInstance();

    @Override
    public void login(String username, String password, OnLoginCallback onLoginCallback) {
        try {
            List<User> users = userDao.selectAllUsers(username, password);
            if (users.size() == 0) {
                onLoginCallback.onFailure("账号密码错误");
                return;
            }
            onLoginCallback.onSuccess(users.get(0));
        } catch (SQLException throwables) {
            onLoginCallback.onFailure(throwables.getMessage());
        }
    }
}
