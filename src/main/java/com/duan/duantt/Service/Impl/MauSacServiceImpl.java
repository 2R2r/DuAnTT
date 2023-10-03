package com.duan.duantt.Service.Impl;


import com.duan.duantt.Entity.KichThuoc;
import com.duan.duantt.Entity.MauSac;
import com.duan.duantt.Repository.KichThuocRepository;
import com.duan.duantt.Repository.MauSacRepository;
import com.duan.duantt.Service.KichThuocService;
import com.duan.duantt.Service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MauSacServiceImpl implements MauSacService {

    @Autowired
    private MauSacRepository repository;

    public List<MauSac> getAll() {
        return repository.findAll();
    }

    @Override
    public void add(MauSac mauSac) {
        repository.save(mauSac);
    }

    @Override
    public MauSac detail(UUID id) {
        return repository.getMauSacById(id);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
