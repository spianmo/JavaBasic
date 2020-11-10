package org.spianmo.learn.week9.utils;

import org.spianmo.learn.week9.dao.Impl.UserDaoImpl;
import org.spianmo.learn.week9.dao.UserDao;

public class DaoFactory {
    public static UserDao getUserDaoInstance() {
        return new UserDaoImpl();
    }
}
