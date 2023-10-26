package com.duan.duantt.Service;

import com.duan.duantt.Entity.SanPham;
import com.duan.duantt.ViewModel.ViewSanPham;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SanPhamService {

    public List<ViewSanPham> getAllViewSanPham();


    Optional<ViewSanPham> findById(UUID id);


    List<ViewSanPham> findByTheLoaiId(UUID id);


    List<ViewSanPham> findByTenContaining(String ten);
}