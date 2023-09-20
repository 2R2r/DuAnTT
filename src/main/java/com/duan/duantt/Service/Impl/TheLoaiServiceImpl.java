package com.duan.duantt.Service.Impl;


import com.duan.duantt.Entity.TheLoai;
import com.duan.duantt.Repository.TheLoaiRepository;
import com.duan.duantt.Service.TheLoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheLoaiServiceImpl implements TheLoaiService {

    @Autowired
    private TheLoaiRepository repository;

    public List<TheLoai> getAll(){
        return repository.findAll();
    }
}
