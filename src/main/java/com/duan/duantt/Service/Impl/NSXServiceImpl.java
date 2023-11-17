package com.duan.duantt.Service.Impl;

import com.duan.duantt.Entity.NSX;
import com.duan.duantt.Repository.NSXRepository;
import com.duan.duantt.Service.NSXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NSXServiceImpl implements NSXService {
    @Autowired
    private NSXRepository nsxRepository;

    @Override
    public List<NSX> getAll() {
        return nsxRepository.findAll();
    }

    @Override
    public void add(NSX nsx) {
        nsxRepository.save(nsx);
    }

    @Override
    public NSX detail(UUID id) {
        return nsxRepository.getNSXById(id);
    }

    @Override
    public void delete(UUID id) {
        nsxRepository.deleteById(id);
    }
}
