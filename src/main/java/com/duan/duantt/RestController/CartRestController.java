package com.duan.duantt.RestController;


import ch.qos.logback.core.model.Model;
import com.duan.duantt.Entity.ChiTietGioHang;
import com.duan.duantt.Entity.ChiTietSanPham;
import com.duan.duantt.Entity.GioHang;
import com.duan.duantt.Entity.NguoiDung;
import com.duan.duantt.Service.*;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/rest")
@RestController
public class CartRestController {

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private KichThuocService kichThuocService;

    @Autowired
    private MauSacService mauSacService;

    @Autowired
    private GioHangService gioHangService;

    @Autowired
    private NguoiDungService nguoiDungService;

    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;

    @Autowired
    private ChiTietGioHangService chiTietGioHangService;

    @GetMapping("/chitietgiohang")
    public List<ChiTietGioHang> getChiTietGioHang(HttpSession session) {
        UUID uuid = UUID.fromString("1127166f-2172-44ad-9606-8314a9919fd9");
        Optional<NguoiDung> nguoiDung = nguoiDungService.findById(uuid);

        if (nguoiDung.isPresent()) {
            GioHang gioHang = gioHangService.findByNguoiDungId(nguoiDung.get().getId());

            if (gioHang != null) {

                List<ChiTietGioHang> chiTietGioHang = chiTietGioHangService.findAllByIdGioHang(gioHang.getId());


                return chiTietGioHang;
            }
        }

        return Collections.emptyList();
    }


    @PostMapping("/cart/add")
    public ResponseEntity<?> handleSelectedData(
            @RequestBody JsonNode orderData) {

        String productIdString = orderData.get("productId").asText(); // Lấy giá trị UUID dưới dạng String
        UUID productId = UUID.fromString(productIdString); // Chuyển String sang UUID

        UUID uuid = UUID.fromString("1127166f-2172-44ad-9606-8314a9919fd9");
        Optional<NguoiDung> nguoiDung = nguoiDungService.findById(uuid);

        if (nguoiDung != null && productId != null) {
            GioHang gioHang = gioHangService.findByNguoiDungId(nguoiDung.get().getId());

            if (gioHang == null) {
                gioHang = new GioHang();
                gioHang.setNguoiDung(nguoiDung.get());
                gioHang = gioHangService.save(gioHang);
            }

            Optional<ChiTietSanPham> chiTietSanPham = chiTietSanPhamService.findById(productId);

            if (chiTietSanPham.isPresent()) {
                ChiTietGioHang chiTietGioHang = chiTietGioHangService.findAllByIdGioHang(gioHang.getId()).stream()
                        .filter(ctgh -> ctgh.getChiTietSanPham().getId().equals(chiTietSanPham.get().getId()))
                        .findFirst()
                        .orElse(null);

                if (chiTietGioHang != null) {
                    chiTietGioHang.setSoLuong(chiTietGioHang.getSoLuong() + 1);
                } else {
                    ChiTietGioHang newChiTietGioHang = new ChiTietGioHang();
                    newChiTietGioHang.setGioHang(gioHang);
                    newChiTietGioHang.setChiTietSanPham(chiTietSanPham.get());
                    newChiTietGioHang.setSoLuong(1);
                    chiTietGioHang = newChiTietGioHang;
                }

                chiTietGioHangService.save(chiTietGioHang);

                // Cập nhật lại số lượng của ChiTietSanPham
                chiTietSanPham.get().setSoLuong(chiTietSanPham.get().getSoLuong() - 1);
                chiTietSanPhamService.save(chiTietSanPham.get());

                return ResponseEntity.ok(chiTietGioHang);
            }
        }

        return ResponseEntity.status(400).body(null);
    }


    @PostMapping("/cart/update")
    public ResponseEntity<?> update(
            @RequestBody JsonNode orderData) {

        String productIdString = orderData.get("productId").asText(); // Lấy giá trị UUID dưới dạng String
        UUID productId = UUID.fromString(productIdString); // Chuyển String sang UUID
        int quantity = orderData.get("quantity").asInt(); // Lấy giá trị số lượng

        if (productId != null && quantity >= 0) {
            Optional<ChiTietGioHang> chiTietGioHang = chiTietGioHangService.findById(productId);
            if (chiTietGioHang.isPresent()) {
                Optional<ChiTietSanPham> chiTietSanPham = chiTietSanPhamService.findById(chiTietGioHang.get().getChiTietSanPham().getId());
                int soLuongThayDoi = chiTietGioHang.get().getSoLuong() - quantity;

                if (quantity == 0) {
                    chiTietSanPham.get().setSoLuong(chiTietSanPham.get().getSoLuong() + soLuongThayDoi);
                    chiTietSanPhamService.save(chiTietSanPham.get());
                    chiTietGioHangService.deleteById(productId);
                    return ResponseEntity.ok("Updated and Deleted successfully");
                }

                chiTietGioHang.get().setSoLuong(quantity);
                ChiTietGioHang chiTietGioHang1 = chiTietGioHangService.save(chiTietGioHang.get());
                chiTietSanPham.get().setSoLuong(chiTietSanPham.get().getSoLuong() + soLuongThayDoi);
                chiTietSanPhamService.save(chiTietSanPham.get());

                return ResponseEntity.ok(chiTietGioHang1);
            }
        }
        return ResponseEntity.status(400).body("Invalid request data");
    }


    @Transactional
    @PostMapping("/cart/remove")
    public String remove(
            @RequestBody JsonNode orderData, Model model) {

        String productIdString = orderData.get("productId").asText(); // Lấy giá trị UUID dưới dạng String
        UUID productId = UUID.fromString(productIdString); // Chuyển String sang UUID

        if (productId != null){
            Optional<ChiTietGioHang> chiTietGioHang = chiTietGioHangService.findById(productId);

            if (chiTietGioHang.isPresent()) {
                ChiTietSanPham chiTietSanPham = chiTietGioHang.get().getChiTietSanPham();
                int soLuongThayDoi = chiTietGioHang.get().getSoLuong();

                // Cập nhật số lượng của ChiTietSanPham
                chiTietSanPham.setSoLuong(chiTietSanPham.getSoLuong() + soLuongThayDoi);
                chiTietSanPhamService.save(chiTietSanPham);

                // Xóa ChiTietGioHang
                chiTietGioHangService.deleteById(productId);
            }
        }

        return "cart/viewCart";
    }


    @PostMapping("/cart/clear")
    public void clearCart() {
        UUID uuid = UUID.fromString("1127166f-2172-44ad-9606-8314a9919fd9");
        Optional<NguoiDung> nguoiDung = nguoiDungService.findById(uuid);

        if (nguoiDung.isPresent()) {
            GioHang gioHang = gioHangService.findByNguoiDungId(nguoiDung.get().getId());

            if (gioHang != null) {
                List<ChiTietGioHang> chiTietGioHangs = chiTietGioHangService.findAllByIdGioHang(gioHang.getId());

                for (ChiTietGioHang chiTietGioHang : chiTietGioHangs) {
                    ChiTietSanPham chiTietSanPham = chiTietGioHang.getChiTietSanPham();
                    int soLuongHienTai = chiTietSanPham.getSoLuong();
                    int soLuongThem = chiTietGioHang.getSoLuong();
                    chiTietSanPham.setSoLuong(soLuongHienTai + soLuongThem);
                    chiTietSanPhamService.save(chiTietSanPham);
                }

                // Xóa tất cả ChiTietGioHang sau khi cập nhật thành công ChiTietSanPham
                chiTietGioHangService.deleteAllByGioHang_Id(gioHang.getId());

            }
        }

    }

}
