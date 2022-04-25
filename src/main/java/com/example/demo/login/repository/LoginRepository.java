package com.example.demo.login.repository;

import com.example.demo.login.form.LoginForm;
import com.example.demo.login.model.LoginBean;

public interface LoginRepository {

    LoginBean getUserLoginInfo(LoginForm form);
}
