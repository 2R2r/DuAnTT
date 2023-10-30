package com.duan.duantt.Service;

import com.duan.duantt.Entity.ChiTietSanPham;

import java.util.List;
import java.util.UUID;

public interface ChiTietSanPhamService {
    List<ChiTietSanPham> getAll();

    ChiTietSanPham add(ChiTietSanPham chiTietSanPham );

    ChiTietSanPham getById(UUID id);

    void delete(UUID id);

    void update(ChiTietSanPham chiTietSanPham);
}
