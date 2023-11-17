package com.duan.duantt.Service.Impl;

import com.duan.duantt.Entity.ChiTietSanPham;
import com.duan.duantt.Entity.ChiTietSanPham;
import com.duan.duantt.Repository.ChiTietSanPhamRepository;
import com.duan.duantt.Service.ChiTietSanPhamService;
import com.duan.duantt.Service.ChiTietSanPhamService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChiTietSanPhamService2Impl implements ChiTietSanPhamService2 {
    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;
    @Override
    public List<ChiTietSanPham> getAll() {
        return chiTietSanPhamRepository.findAll();
    }

    @Override
    public ChiTietSanPham add(ChiTietSanPham chiTietSanPham) {
        return chiTietSanPhamRepository.save(chiTietSanPham);
    }

    @Override
    public ChiTietSanPham getById(UUID id) {
        return chiTietSanPhamRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(UUID id) {
        chiTietSanPhamRepository.deleteById(id);
    }

    @Override
    public void update(ChiTietSanPham chiTietSanPham) {
        chiTietSanPhamRepository.save(chiTietSanPham);
    }
}
