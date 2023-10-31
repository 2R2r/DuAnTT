package com.duan.duantt.Controller;


import com.duan.duantt.Entity.ChiTietSanPham;
import com.duan.duantt.Entity.KichThuoc;
import com.duan.duantt.Entity.MauSac;
import com.duan.duantt.Entity.SanPham;
import com.duan.duantt.Service.ChiTietSanPhamService;
import com.duan.duantt.Service.KichThuocService;
import com.duan.duantt.Service.MauSacService;
import com.duan.duantt.Service.SanPhamService;
import com.duan.duantt.ViewModel.ViewSanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


//    lll
//sss

    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;


    @GetMapping("/cart/view")
    public String list(Model model){
        return "cart/viewCart";
    }

    @GetMapping("/product/list")
    public String list(Model model, @RequestParam("cid") Optional<UUID> cid) {

        if (cid.isPresent()) {
            model.addAttribute("items", sanPhamService.findByTheLoaiId(cid.get()));
            return "sanpham/list";
        } else {
            model.addAttribute("items", sanPhamService.getAllViewSanPham());
            return "sanpham/list";
        }

    }

    @GetMapping("/product/detail/{id}")
    public String detail(Model model, @PathVariable("id") UUID id) {
        // Assume sanPhamService and chiTietSanPhamService are properly injected and implemented
            ViewSanPham sanPham = sanPhamService.findById(id).orElse(null);
        if (sanPham != null) {
            List<MauSac> listOfMauSac = chiTietSanPhamService.findDistinctColorsBySanPhamId(id);
            List<KichThuoc> listOfKichThuoc = chiTietSanPhamService.findDistinctSizesBySanPhamId(id);

            model.addAttribute("item", sanPham);
            model.addAttribute("listOfMauSac", listOfMauSac);
            model.addAttribute("listOfKichThuoc", listOfKichThuoc);

            return "sanpham/detail";
        }

        return "error"; // Handle case when product is not found
    }

    @PostMapping("/product/detail")
    @ResponseBody
    public ResponseEntity<?> handleSelectedData(
            @RequestParam UUID colorId,
            @RequestParam(required = false) UUID sizeId,
            @RequestParam UUID productId) {
        ChiTietSanPham chiTietSanPham = null;

        if (colorId != null && sizeId != null && productId != null) {
            chiTietSanPham = chiTietSanPhamService.findByMauSacIdAndKichThuocIdAndSanPhamId(colorId, sizeId, productId);
        }

        if (chiTietSanPham != null) {
            return ResponseEntity.ok(chiTietSanPham);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }


    @PostMapping("/product/detailImage")
    @ResponseBody
    public ResponseEntity<?> handleSelectedData2(
            @RequestParam UUID colorId,
            @RequestParam UUID productId) {

        if (colorId != null && productId != null) {
            List<ChiTietSanPham> chiTietSanPh2 = chiTietSanPhamService.findChiTietSanPhamByMauSacAndSanPham(colorId, productId);
            return ResponseEntity.ok(chiTietSanPh2.get(0));
        }
        return ResponseEntity.badRequest().body(null);

    }

    @GetMapping("/product/search")
    public String searchSanPham(@RequestParam String ten,Model model) {

        model.addAttribute("items", sanPhamService.findByTenContaining(ten));
        return "sanpham/list";
    }
}


