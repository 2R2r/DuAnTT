package com.duan.duantt.Service.Impl;


import com.duan.duantt.Entity.KichThuoc;
import com.duan.duantt.Repository.KichThuocRepository;
import com.duan.duantt.Service.KichThuocService;
import com.duan.duantt.Service.TheLoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KichThuocServiceImpl implements KichThuocService {

    @Autowired
    private KichThuocRepository repository;

    public List<KichThuoc> getAll() {
        return repository.findAll();
    }

    @Override
    public void add(KichThuoc kichThuoc) {
        repository.save(kichThuoc);
    }

    @Override
    public KichThuoc detail(UUID id) {
        return repository.getKichThuocById(id);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
