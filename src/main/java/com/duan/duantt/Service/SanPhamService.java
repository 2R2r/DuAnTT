package com.duan.duantt.Service;

import com.duan.duantt.Entity.SanPham;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SanPhamService {

    List<SanPham> getAll();


    Optional<SanPham> findById(UUID id);


    List<SanPham> findByCategoryId(UUID id);
}