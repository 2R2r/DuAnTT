package com.duan.duantt.security;

import com.duan.duantt.Repository.NguoiDungRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class AuthController {

    Authentication authentication = null;

    public Authentication getAuthentication() {
        return authentication;
    }

    @Autowired
    private NguoiDungRepository accountRepository;


    @GetMapping("/auth/login/form")
    public String login(Model model) {

        return "login/login";

    }

    @GetMapping("/auth/register/form")
    public String register(Model model) {
        return "login/register";

    }

    @GetMapping("/auth/login/success")
    public String success(HttpSession session,Model  model) {
        if (authentication != null && !"anonymousUser".equals(authentication.getPrincipal())){
            model.addAttribute("ten",getAuthentication().getName());

        }
        authentication = SecurityContextHolder.getContext().getAuthentication();

        return "forward:/home/product";
    }


    @GetMapping("/auth/login/error")
    public String error(Model model) {
        model.addAttribute("message", "Sai thong tin dang nhap");
        return "forward:/auth/login/form";
    }

    @GetMapping("/auth/logoff/success")
    public String logoff(Model model,HttpSession session) {
        session.setAttribute("authenticatedUserName",authentication.getName());

        authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("message", "Dang xuat thanh cong bấm login mới có thể đăng nhập tiếp");
        return "forward:/home/product";

    }

    @GetMapping("/auth/access/denied")
    public String denied(Model model) {
        model.addAttribute("message", "Ban ko co quyen truy xuat");
        return "login/login";
    }


}
