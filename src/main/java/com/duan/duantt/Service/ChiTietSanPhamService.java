package com.duan.duantt.Service;

import com.duan.duantt.Entity.ChiTietGioHang;
import com.duan.duantt.Entity.ChiTietSanPham;
import com.duan.duantt.Entity.KichThuoc;
import com.duan.duantt.Entity.MauSac;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChiTietSanPhamService {

    List<String> findHinhAnhBySanPhamAndMauSac(UUID idSanPham, UUID idMauSac);

    List<MauSac> findDistinctColorsBySanPhamId(UUID sanPhamId);

    List<KichThuoc> findDistinctSizesBySanPhamId(UUID sanPhamId);

    List<ChiTietSanPham> findBySanPhamId(UUID idSanPham);

    ChiTietSanPham findByMauSacIdAndKichThuocIdAndSanPhamId(UUID mauSacId, UUID kichThuocId, UUID sanPhamId);

    List<ChiTietSanPham> findChiTietSanPhamByMauSacAndSanPham( UUID mauSacId, UUID sanPhamId);

    Optional<ChiTietSanPham> findById(UUID uuid);

    ChiTietSanPham save(ChiTietSanPham chiTietSanPham);

}
