package org.spianmo.learn.week9.service;

import org.spianmo.learn.week9.service.Impl.callback.OnLoginCallback;

/**
 * @ClassName LoginService
 * @Description TODO
 * @Author Finger
 * @Date 11/9/2020
 **/
public interface LoginService {
    void login(String username, String password, OnLoginCallback onLoginCallback);
}
