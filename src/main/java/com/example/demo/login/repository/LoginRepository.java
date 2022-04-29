package com.example.demo.login.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.login.form.LoginForm;
import com.example.demo.login.model.LoginBean;

@Mapper
public interface LoginRepository {

    LoginBean getLoginUser(LoginForm form);
}
