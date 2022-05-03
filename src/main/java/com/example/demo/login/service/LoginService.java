package com.example.demo.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.login.form.LoginForm;
import com.example.demo.login.mapper.LoginMapper;
import com.example.demo.login.model.LoginBean;

@Service
public class LoginService {
    
    @Autowired
    LoginMapper loginRepository;
    
    /**
     * ログイン機能
     * 
     * @param form ログイン画面フォーム
     * @return 検索結果
     */
    public LoginBean txSelectLoginUser(LoginForm form) {
        
        LoginBean bean;
        try {
         // ユーザー検索処理
            bean = loginRepository.getLoginUser(form);
        } catch (Exception e) {
            return null;
        }
        
        return bean;
    }
    
    /**
     * ユーザ登録機能
     * 
     * @param form 新規登録画面フォーム
     * @return 検索結果
     */
    public int txInsertUser(LoginForm form) {
        
        // ユーザ登録処理
        int count;
        try {
            count = loginRepository.insertUser(form);
        } catch (Exception e) {
            count = 0;
            return count;
        }
        
        return count;
    }

}
