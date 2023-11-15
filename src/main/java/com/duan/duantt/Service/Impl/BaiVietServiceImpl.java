package com.duan.duantt.Service.Impl;

import com.duan.duantt.Entity.BaiViet;
import com.duan.duantt.Repository.BaiVietRepository;
import com.duan.duantt.Service.BaiVietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BaiVietServiceImpl implements BaiVietService {
    @Autowired
    private BaiVietRepository baiVietRepository;

    @Override
    public List<BaiViet> getAll() {
        return baiVietRepository.findAll();
    }

    @Override
    public void add(BaiViet baiViet) {
        baiVietRepository.save(baiViet);
    }

    @Override
    public BaiViet detail(UUID id) {
        return baiVietRepository.getBaiVietById(id);
    }

    @Override
    public void delete(UUID id) {
        baiVietRepository.deleteById(id);
    }
}
