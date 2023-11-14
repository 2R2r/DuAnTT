package com.duan.duantt.Controller;

import com.duan.duantt.Entity.NguoiDung;
import com.duan.duantt.Service.DonHangService;
import com.duan.duantt.Service.NguoiDungService;
import com.duan.duantt.security.AuthController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.UUID;

@Controller

public class OrderController {

    @Autowired
    private AuthController authController;

    @Autowired
    private DonHangService donHangService;

    @Autowired
    private NguoiDungService nguoiDungService;

    @GetMapping("/order/checkout")
    public String checkout(){
        return "order/checkout";
    }

    @GetMapping("/order/list")
    public String list(Model model){

        if (authController.getAuthentication() != null){
            Optional<NguoiDung> nguoiDung = nguoiDungService.findByTaiKhoan(authController.getAuthentication().getName());
            model.addAttribute("ten",authController.getAuthentication().getName());

        if (nguoiDung.isPresent()) {
            model.addAttribute("listOrder",donHangService.findByNguoiDungId(nguoiDung.get().getId()));
        }
        }

        return "order/list";
    }

    @GetMapping("/order/detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model){
        if (authController.getAuthentication() != null){
            model.addAttribute("ten",authController.getAuthentication().getName());

        }

        model.addAttribute("order",donHangService.findById(id).get());
        return "order/detail";
    }
}
