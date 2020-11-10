package org.spianmo.learn.week9.service.Impl.callback;

import org.spianmo.learn.week9.entity.User;

public interface OnLoginCallback {
    void onSuccess(User user);
    void onFailure(String errMsg);
}
