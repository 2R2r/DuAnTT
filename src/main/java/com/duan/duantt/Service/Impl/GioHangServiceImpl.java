package com.duan.duantt.Service.Impl;


import com.duan.duantt.Entity.GioHang;
import com.duan.duantt.Repository.GioHangRepository;
import com.duan.duantt.Repository.NguoiDungRepository;
import com.duan.duantt.Service.GioHangService;
import com.duan.duantt.Service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GioHangServiceImpl implements GioHangService {

    @Autowired
    private GioHangRepository repository;

    @Override
    public GioHang findByNguoiDungId(UUID nguoiDungId) {
        return repository.findByNguoiDungId(nguoiDungId);
    }

    @Override
    public GioHang save(GioHang gioHang) {
        return repository.save(gioHang);
    }
}
