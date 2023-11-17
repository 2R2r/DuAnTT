package com.duan.duantt.Controller;

import com.duan.duantt.Entity.NguoiDung;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("")
    public String admin(Model model){
        return "admin/homeAdmin";
    }
}
