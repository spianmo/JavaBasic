package org.spianmo.learn.week9.entity;

import java.sql.Timestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName User
 * @Description TODO
 * @Author Finger
 * @Date 11/9/2020
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public enum Sex {
        MAN(0), WOMAN(1), UNKNOWN(2);
        private int value = 0;

        Sex(int value) {     //必须是private的，否则编译错误
            this.value = value;
        }

        public static Sex valueOf(int value) {    //手写的从int到enum的转换函数
            switch (value) {
                case 0:
                    return MAN;
                case 1:
                    return WOMAN;
                case 2:
                    return UNKNOWN;
                default:
                    return null;
            }
        }

        public int value() {
            return this.value;
        }
    }

    private int id;
    @NotNull(message = "账号不能为空")
    private String username;
    @NotNull(message = "密码不能为空")
    private String passwd;
    @NotNull(message = "昵称不能为空")
    private String nickname;
    private String openid;
    private Sex sex;
    @Email
    @NotNull(message = "邮箱不能为空")
    private String email;
    private String nationalid;
    private Timestamp regtime;
    private Timestamp sigendtime;
    private Timestamp lastlogintime;
}
