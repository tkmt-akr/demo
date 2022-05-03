package com.example.demo.login.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.login.form.LoginForm;
import com.example.demo.login.model.LoginBean;

@Mapper
public interface LoginMapper {

    /**
     * ログインユーザ検索処理
     * 
     * @param form ログイン画面フォーム
     * @return 検索結果
     */
    LoginBean getLoginUser(LoginForm form);
    
    /**
     * ユーザ登録処理
     * 
     * @param form 新規登録画面フォーム
     * @return 登録件数
     */
    int insertUser(LoginForm form);
}
