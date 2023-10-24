package com.duan.duantt.RestController;


import com.duan.duantt.Entity.ChiTietSanPham;
import com.duan.duantt.Entity.KichThuoc;
import com.duan.duantt.Entity.MauSac;
import com.duan.duantt.Service.ChiTietSanPhamService;
import com.duan.duantt.Service.SanPhamService;
import com.duan.duantt.ViewModel.ViewSanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
@RestController
@RequestMapping("/api/product")

public class ProductRestController {
    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;


    @GetMapping("/list")
    public ResponseEntity<?> getProducts() {
        List<ViewSanPham> productList;
            productList = sanPhamService.getAllViewSanPham();
        return ResponseEntity.ok(productList);
    }



//    @GetMapping("/detail/{id}")
//    public ResponseEntity<?> getProductDetail(@PathVariable("id") UUID id) {
//        ViewSanPham sanPham = sanPhamService.findById(id).orElse(null);
//
//        if (sanPham != null) {
//            List<MauSac> listOfMauSac = chiTietSanPhamService.findDistinctColorsBySanPhamId(id);
//            List<KichThuoc> listOfKichThuoc = chiTietSanPhamService.findDistinctSizesBySanPhamId(id);
//
//            Map<String, Object> responseData = new HashMap<>();
//            responseData.put("item", sanPham);
//            responseData.put("listOfMauSac", listOfMauSac);
//            responseData.put("listOfKichThuoc", listOfKichThuoc);
//
//            return ResponseEntity.ok(responseData);
//        }
//
//        return ResponseEntity.notFound().build();
//    }
//
//
//    @PostMapping("/detail")
//    public ResponseEntity<?> handleSelectedData(
//            @RequestParam UUID colorId,
//            @RequestParam(required = false) UUID sizeId,
//            @RequestParam UUID productId) {
//        ChiTietSanPham chiTietSanPham = null;
//
//        if (colorId != null && sizeId != null && productId != null) {
//            chiTietSanPham = chiTietSanPhamService.findByMauSacIdAndKichThuocIdAndSanPhamId(colorId, sizeId, productId);
//        }
//
//        if (chiTietSanPham != null) {
//            return ResponseEntity.ok(chiTietSanPham);
//        } else {
//            return ResponseEntity.status(404).body(null);
//        }
//    }
//
//    @PostMapping("/detailImage")
//    public ResponseEntity<?> handleSelectedData2(
//            @RequestParam UUID colorId,
//            @RequestParam UUID productId) {
//
//        if (colorId != null && productId != null) {
//            List<ChiTietSanPham> chiTietSanPh2 = chiTietSanPhamService.findChiTietSanPhamByMauSacAndSanPham(colorId, productId);
//            return ResponseEntity.ok(chiTietSanPh2.get(0));
//        }
//        return ResponseEntity.badRequest().body(null);
//    }
}