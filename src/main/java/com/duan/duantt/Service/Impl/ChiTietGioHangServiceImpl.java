package com.duan.duantt.Service.Impl;


import com.duan.duantt.Entity.ChiTietGioHang;
import com.duan.duantt.Entity.ChiTietSanPham;
import com.duan.duantt.Repository.ChiTietGioHangRepository;
import com.duan.duantt.Repository.NguoiDungRepository;
import com.duan.duantt.Service.ChiTietDonHangService;
import com.duan.duantt.Service.ChiTietGioHangService;
import com.duan.duantt.Service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChiTietGioHangServiceImpl implements ChiTietGioHangService {

    @Autowired
    private ChiTietGioHangRepository repository;


    @Override
    public ChiTietGioHang save(ChiTietGioHang chiTietGioHang) {
        return repository.save(chiTietGioHang);
    }

    public List<ChiTietGioHang> layChiTietGioHangTheoIdGioHang(UUID idGioHang) {
        return repository.findAllByGioHang_Id(idGioHang);
    }

    @Override
    public List<ChiTietGioHang> findAllByIdGioHang(UUID uuid) {
        return repository.findAllByGioHang_Id(uuid);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<ChiTietGioHang> findById(UUID uuid) {
        Optional<ChiTietGioHang> chiTietGioHang = repository.findById(uuid);

        if (chiTietGioHang.isPresent()){
            return chiTietGioHang;
        }

        return Optional.empty();
    }

    @Override
    public void deleteAllByGioHang_Id(UUID idGioHang) {
        repository.deleteAllByGioHang_Id(idGioHang);
    }
}
