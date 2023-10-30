package com.duan.duantt.Service.Impl;

import com.duan.duantt.Entity.SanPham;
import com.duan.duantt.Repository.SanPhamRepository;
import com.duan.duantt.Service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    private SanPhamRepository repository;


    public List<SanPham> getAll(){
        return repository.findAll();
    }


    public Optional<SanPham> findById(UUID id){
        return repository.findById(id);
    }


    public List<SanPham> findByCategoryId(UUID id){
        return repository.findByTheLoaiId(id);
    }

    @Override
    public SanPham add(SanPham sanPham) {
        return repository.save(sanPham);
    }

    @Override
    public SanPham getById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(UUID id) {
       repository.deleteById(id);
    }

    @Override
    public void update(SanPham sanPham) {
       repository.save(sanPham);
    }
}
