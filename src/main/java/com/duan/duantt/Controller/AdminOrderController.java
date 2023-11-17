package com.duan.duantt.Controller;

import com.duan.duantt.Entity.DonHang;
import com.duan.duantt.Entity.NguoiDung;
import com.duan.duantt.Service.DonHangService;
import com.duan.duantt.Service.NguoiDungService;
import com.duan.duantt.security.AuthController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class AdminOrderController {

    @Autowired
    private AuthController authController;

    @Autowired
    private DonHangService donHangService;

    @Autowired
    private NguoiDungService nguoiDungService;


    @GetMapping("/order")
    public String list(Model model){

        if (authController.getAuthentication() != null){
            Optional<NguoiDung> nguoiDung = nguoiDungService.findByTaiKhoan(authController.getAuthentication().getName());
            model.addAttribute("ten",authController.getAuthentication().getName());

        if (nguoiDung.isPresent()) {
            model.addAttribute("listOrder",donHangService.getAll());
        }
        }

        return "adminOrder/list";
    }

    @GetMapping("/order/detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model){
        if (authController.getAuthentication() != null){
            model.addAttribute("ten",authController.getAuthentication().getName());
        }
        model.addAttribute("order",donHangService.findById(id).get());
        return "adminOrder/detail";
    }

    @PostMapping("/order/cancel/{id}")
    public String cancelOrder(@PathVariable("id") UUID id) {
        Optional<DonHang> optionalOrder = donHangService.findById(id);

        if (optionalOrder.isPresent()) {
            DonHang order = optionalOrder.get();
            order.setTrangThai(0);
            donHangService.save(order);
        }

        return "redirect:/admin/order/list";
    }


    // Endpoint xác nhận đơn hàng
    @PostMapping("/order/confirm/{id}")
    public String confirmOrder(@PathVariable("id") UUID id) {
        Optional<DonHang> optionalOrder = donHangService.findById(id);

        if (optionalOrder.isPresent()) {
            DonHang order = optionalOrder.get();
            // Thực hiện logic xác nhận đơn hàng ở đây (ví dụ: set trạng thái đơn hàng thành "Đã xác nhận")
            order.setTrangThai(1);
            donHangService.save(order); // Lưu thay đổi
        }
            return "redirect:/admin/order/list";

        }
}
