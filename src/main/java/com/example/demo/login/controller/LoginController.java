/**
 * ログイン機能コントローラクラス
 * 
 * ver:1.0.0 (2022/04/24) [新規作成] A
 * 
 */
package com.example.demo.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.form.LoginForm;
import com.example.demo.login.model.LoginBean;
import com.example.demo.login.service.LoginService;

/**
 * ログイン機能コントローラクラス
 * 
 * @author A
 *
 */
@Controller
public class LoginController {
    
    @Autowired
    LoginService loginService;
    
    /**
     * 初期表示
     * 
     * @param model Modelオブジェクト
     * @return String 遷移先
     */
    @GetMapping("/login_moveLogin")
    public String moveLogin(Model model) {
        LoginForm form = new LoginForm();
        model.addAttribute("form", form);
        return "login/login";
    }
    
    /**
     * ログイン処理
     * 
     * @param model Modelオブジェクト
     * @param form  ログイン画面フォーム
     * @return String 遷移先
     */
    @PostMapping("/login_execute")
    public String executeLogin(Model model,
                          @ModelAttribute LoginForm form) throws Exception {
        
        // ユーザー検索
        LoginBean bean = loginService.txSelectLoginUser(form);
        
        // 検索結果が0件の場合
        if (bean == null) {
            return "login/login";
        }
        
        return "detail/detail";
    }

    /**
     * 新規登録画面へ遷移
     * 
     * @return String 遷移先
     */
    @GetMapping("/register_move")
    public String moveRegister () {
        return "register/register";
    }

    /**
     * ユーザ新規登録処理
     * 
     * @param model Modelオブジェクト
     * @param form 新規登録画面フォーム
     * @return String 遷移先
     */
    @PostMapping("/register_execute")
    public String executeRegister(Model model,
                          @ModelAttribute LoginForm form) {
        
        // ユーザ登録処理
        int count = loginService.txInsertUser(form);
        
        // 更新件数が0件の場合
        if (count == 0) {
            return "detail/detail";
        }
        
        return "login/login";
    }
}
