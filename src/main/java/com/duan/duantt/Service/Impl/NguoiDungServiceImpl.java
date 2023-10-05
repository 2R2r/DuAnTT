package com.duan.duantt.Service.Impl;


import com.duan.duantt.Entity.NguoiDung;
import com.duan.duantt.Repository.ChiTietDonHangRepository;
import com.duan.duantt.Repository.NguoiDungRepository;
import com.duan.duantt.Service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class NguoiDungServiceImpl implements NguoiDungService {

    @Autowired
    private NguoiDungRepository repository;

    @Override
    public Optional<NguoiDung> findById(UUID uuid) {
        Optional<NguoiDung> nguoiDung = repository.findById(uuid);

        if (nguoiDung.isPresent()){
            return nguoiDung;
        }

        return Optional.empty();
    }
}
