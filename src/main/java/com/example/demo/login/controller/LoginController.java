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
     * @return 遷移先
     */
    @GetMapping("/login_moveLogin")
    public String moveLogin(Model model) {
        LoginForm form = new LoginForm();
        model.addAttribute("form", form);
        return "login/login";
    }
    
    @PostMapping("/login_execute")
    public String execute(Model model,
                          @ModelAttribute LoginForm form) {
        
        // ユーザー検索
        LoginBean bean = loginService.txSelectLoginUser(form);
        
        if (bean == null) {
            return "login/login";
        }
        
        return "detail/detail";
    }
}
