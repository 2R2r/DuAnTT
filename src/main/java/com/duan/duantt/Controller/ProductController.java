package com.duan.duantt.Controller;


import com.duan.duantt.Entity.*;
import com.duan.duantt.Service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private KichThuocService kichThuocService;

    @Autowired
    private MauSacService mauSacService;

    @Autowired
    private NSXService nsxService ;

    @Autowired
    private TheLoaiService theLoaiService;

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
    @GetMapping("hien-thi")
    public String getAllBypage(Model model){
        List<SanPham> sanPhams = sanPhamService.getAll();
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
        sanPhamService.add(sanPham);
        session.setAttribute("successMessage", "Thêm thành công");
        return "redirect:/product/hien-thi";

    }

    @GetMapping("view-update/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        SanPham sanPhams = sanPhamService.getById(id);
        List<NSX> nsxs = nsxService.getAll() ;
        List<TheLoai> theLoais = theLoaiService.getAll();
        model.addAttribute("nsxs",nsxs);
        model.addAttribute("theLoais",theLoais);
        model.addAttribute("product",sanPhams);

        return "sanpham/detail1";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID id){
       sanPhamService.delete(id);
        return "redirect:/product/hien-thi";
    }


    @PostMapping("update")
    public String update(@ModelAttribute("product") SanPham sanPham, Model model, HttpSession session){

        sanPhamService.update(sanPham);
        session.setAttribute("successMessage", "Thêm thành công");
        return "redirect:/product/hien-thi";

    }
}
