package com.springapp.mvc.model;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;
/**
 * Created by Dto on 1/5/14.
 */
public class Login {

    String userName;
    @NotBlank
    String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
