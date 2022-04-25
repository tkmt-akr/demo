package com.example.demo.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.login.form.LoginForm;
import com.example.demo.login.model.LoginBean;
import com.example.demo.login.repository.LoginRepository;

@Service
public class LoginService {
    
    @Autowired
    LoginRepository loginRepository;
    
    public LoginBean txSelectLoginUser(LoginForm form) {
        
        // ユーザー検索
        LoginBean bean = loginRepository.getUserLoginInfo(form);
        
        return bean;
    }

}
