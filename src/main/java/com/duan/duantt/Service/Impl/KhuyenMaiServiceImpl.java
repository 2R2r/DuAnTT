package com.duan.duantt.Service.Impl;


import com.duan.duantt.Entity.KhuyenMai;
import com.duan.duantt.Repository.KhuyenMaiRepository;
import com.duan.duantt.Repository.NguoiDungRepository;
import com.duan.duantt.Service.KhuyenMaiService;
import com.duan.duantt.Service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KhuyenMaiServiceImpl implements KhuyenMaiService {

    @Autowired
    private KhuyenMaiRepository repository;

    @Override
    public Optional<KhuyenMai> findByMa(String maKm) {

        return repository.findByMa(maKm);
    }
}
