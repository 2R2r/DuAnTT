package com.duan.duantt.RestController;

import com.duan.duantt.Entity.GioHang;
import com.duan.duantt.Entity.KhuyenMai;
import com.duan.duantt.Entity.NguoiDung;
import com.duan.duantt.Service.*;
import com.duan.duantt.security.AuthController;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;
@RestController
public class OrrderRestController {

    @Autowired
    private AuthController authController;

    @Autowired
    private GioHangService gioHangService;

    @Autowired
    private NguoiDungService nguoiDungService;

    @Autowired
    private ChiTietGioHangService chiTietGioHangService;

    @Autowired
    private DonHangService donHangService;

    @Autowired
    private KhuyenMaiService khuyenMaiService;


    @Transactional
    @PostMapping("/rest/order/add")
    public ResponseEntity<?> create(@RequestBody JsonNode orderData){
        Optional<NguoiDung> nguoiDung = nguoiDungService.findByTaiKhoan(authController.getAuthentication().getName());


        if (nguoiDung.isPresent()) {
            GioHang gioHang = gioHangService.findByNguoiDungId(nguoiDung.get().getId());

            if (gioHang != null) {
                chiTietGioHangService.deleteAllByGioHang_Id(gioHang.getId());
                return  ResponseEntity.ok(donHangService.create(orderData));
            }
        }
        return ResponseEntity.status(400).body(null);

    }

    @PostMapping("/rest/order/addKM")
    public ResponseEntity<?> update(
            @RequestBody JsonNode orderData) {
        String kmMa = orderData.get("kmMa").asText(); // Lấy giá trị UUID dưới dạng String

        Optional<KhuyenMai> khuyenMai = khuyenMaiService.findByMa(kmMa);
        if (khuyenMai.isPresent()){
            return ResponseEntity.ok(khuyenMai.get());
        }
        return ResponseEntity.status(400).body(null);

    }

}
