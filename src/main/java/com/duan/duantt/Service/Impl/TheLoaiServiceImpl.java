package com.duan.duantt.Service.Impl;


import com.duan.duantt.Entity.TheLoai;
import com.duan.duantt.Repository.TheLoaiRepository;
import com.duan.duantt.Service.TheLoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TheLoaiServiceImpl implements TheLoaiService {

    @Autowired
    private TheLoaiRepository repository;

    public List<TheLoai> getAll() {
        return repository.findAll();
    }

    @Override
    public void add(TheLoai theLoai) {
        repository.save(theLoai);
    }

    @Override
    public TheLoai detail(UUID id) {
        return repository.getTheLoaiById(id);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
