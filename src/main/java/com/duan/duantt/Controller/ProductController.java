package com.duan.duantt.Controller;


import com.duan.duantt.Entity.ChiTietSanPham;
import com.duan.duantt.Entity.KichThuoc;
import com.duan.duantt.Entity.MauSac;
import com.duan.duantt.Entity.NSX;
import com.duan.duantt.Entity.SanPham;
import com.duan.duantt.Entity.TheLoai;
import com.duan.duantt.Service.ChiTietSanPhamService;
import com.duan.duantt.Service.KichThuocService;
import com.duan.duantt.Service.MauSacService;
import com.duan.duantt.Service.NSXService;
import com.duan.duantt.Service.SanPhamService;
import com.duan.duantt.Service.SanPhamService2;
import com.duan.duantt.Service.TheLoaiService;
import com.duan.duantt.ViewModel.ViewSanPham;
import com.duan.duantt.security.AuthController;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Controller
@RequestMapping("/admin/san-pham/")

public class ProductController {

    @Autowired
    private AuthController authController;

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private SanPhamService2 sanPhamService2;

    @Autowired
    private NSXService nsxService ;

    @Autowired
    private TheLoaiService theLoaiService;

    @Autowired
    private MauSacService mauSacService;


//    lll
//sss

    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;

    @GetMapping("hien-thi")
    public String getAllBypage(Model model){
        List<SanPham> sanPhams = sanPhamService2.getAll();
        List<NSX> nsxs = nsxService.getAll() ;
        List<TheLoai> theLoais = theLoaiService.getAll();
        model.addAttribute("list",sanPhams);
        model.addAttribute("nsxs",nsxs);
        model.addAttribute("theLoais",theLoais);
        model.addAttribute("product",new SanPham());
        return "sanpham/list1";
    }

    @PostMapping("add")
    public String add(@ModelAttribute("product") SanPham sanPham, Model model, HttpSession session){
        sanPhamService2.add(sanPham);
        session.setAttribute("successMessage", "Thêm thành công");
        return "redirect:/admin/san-pham/hien-thi";

    }

    @GetMapping("view-update/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        SanPham sanPhams = sanPhamService2.getById(id);
        List<NSX> nsxs = nsxService.getAll() ;
        List<TheLoai> theLoais = theLoaiService.getAll();
        model.addAttribute("nsxs",nsxs);
        model.addAttribute("theLoais",theLoais);
        model.addAttribute("product",sanPhams);

        return "sanpham/detail1";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID id){
        sanPhamService2.delete(id);
        return "redirect:/admin/san-pham/hien-thi";
    }


    @PostMapping("update")
    public String update(@ModelAttribute("product") SanPham sanPham, Model model, HttpSession session){

        sanPhamService2.update(sanPham);
        session.setAttribute("successMessage", "Thêm thành công");
        return "redirect:/admin/san-pham/hien-thi";

    }
}


