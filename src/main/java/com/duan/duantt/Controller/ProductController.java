package com.duan.duantt.Controller;


import com.duan.duantt.Entity.KichThuoc;
import com.duan.duantt.Entity.MauSac;
import com.duan.duantt.Service.KichThuocService;
import com.duan.duantt.Service.MauSacService;
import com.duan.duantt.Service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class ProductController {

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private KichThuocService kichThuocService;

    @Autowired
    private MauSacService mauSacService;

    @GetMapping("/product/list")
    public String list(Model model, @RequestParam("cid") Optional<UUID> cid) {

        if (cid.isPresent()) {
            model.addAttribute("items", sanPhamService.findByCategoryId(cid.get()));
            return "sanpham/list";
        } else {
            model.addAttribute("items", sanPhamService.getAll());
            return "sanpham/list";
        }

    }


    @GetMapping("/product/detail/{id}")
    public String detail(Model model, @PathVariable("id") UUID id) {
        // Lấy danh sách MauSac và KichThuoc
        List<MauSac> mauSacList = mauSacService.getAll();
        List<KichThuoc> kichThuocList = kichThuocService.getAll();

        // Đẩy danh sách vào Model
        model.addAttribute("listOfMauSac", mauSacList);
        model.addAttribute("listOfKichThuoc", kichThuocList);

        model.addAttribute("item", sanPhamService.findById(id).get());
        return "sanpham/detail";
    }
}
