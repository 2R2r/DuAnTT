package com.duan.duantt.Service;

import com.duan.duantt.Entity.ChiTietGioHang;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChiTietGioHangService {

    ChiTietGioHang save(ChiTietGioHang chiTietGioHang);

    List<ChiTietGioHang> layChiTietGioHangTheoIdGioHang(UUID idGioHang);

    List<ChiTietGioHang> findAllByIdGioHang(UUID uuid);

    void deleteById(UUID id);

    Optional<ChiTietGioHang> findById(UUID uuid);

    void deleteAllByGioHang_Id(UUID idGioHang);
}
