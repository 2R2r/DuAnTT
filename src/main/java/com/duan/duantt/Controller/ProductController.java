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


