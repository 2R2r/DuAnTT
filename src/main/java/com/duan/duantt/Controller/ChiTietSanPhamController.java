package com.duan.duantt.Controller;

import com.duan.duantt.Entity.ChiTietSanPham;
import com.duan.duantt.Entity.KichThuoc;
import com.duan.duantt.Entity.MauSac;
import com.duan.duantt.Entity.SanPham;
import com.duan.duantt.Service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/chi-tiet-san-pham/")
public class ChiTietSanPhamController {
    @Autowired
    private ChiTietSanPhamService2 chiTietSanPhamService;
    @Autowired
    private SanPhamService2 sanPhamService;

    @Autowired
    private KichThuocService kichThuocService;

    @Autowired
    private MauSacService mauSacService;

    @GetMapping("hien-thi")
    public String getAllBypage(Model model){
        List<ChiTietSanPham> page = chiTietSanPhamService.getAll();
        List<SanPham> sanPhams = sanPhamService.getAll();
        List<KichThuoc> kichThuocs = kichThuocService.getAll();
        List<MauSac> mauSacs = mauSacService.getAll();
        model.addAttribute("list",page);
        model.addAttribute("sanPhams",sanPhams);
        model.addAttribute("kichThuocs",kichThuocs);
        model.addAttribute("mauSacs",mauSacs);
        model.addAttribute("ctsp",new ChiTietSanPham());
        return "chi-tiet-san-pham/list";
    }

    @PostMapping("add")
    public String add(@ModelAttribute("ctsp") ChiTietSanPham chiTietSanPham,Model model, HttpSession session){
        chiTietSanPhamService.add(chiTietSanPham);
        session.setAttribute("successMessage", "Thêm thành công");
        return "redirect:/admin/chi-tiet-san-pham/hien-thi";

    }

    @GetMapping("view-update/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getById(id);
        model.addAttribute("ctsp", chiTietSanPham);
        List<SanPham> sanPhams = sanPhamService.getAll();
        List<KichThuoc> kichThuocs = kichThuocService.getAll();
        List<MauSac> mauSacs = mauSacService.getAll();
        model.addAttribute("sanPhams",sanPhams);
        model.addAttribute("kichThuocs",kichThuocs);
        model.addAttribute("mauSacs",mauSacs);
        return "chi-tiet-san-pham/detail";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID id){
        chiTietSanPhamService.delete(id);
        return "redirect:/admin/chi-tiet-san-pham/hien-thi";
    }


    @PostMapping("update")
    public String update(@ModelAttribute("ctsp") ChiTietSanPham chiTietSanPham, Model model, HttpSession session){

        chiTietSanPhamService.update(chiTietSanPham);
        session.setAttribute("successMessage", "Thêm thành công");
        return "redirect:/admin/chi-tiet-san-pham/hien-thi";

    }
}

