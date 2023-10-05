package com.duan.duantt.Service.Impl;


import com.duan.duantt.Entity.ChiTietSanPham;
import com.duan.duantt.Entity.KichThuoc;
import com.duan.duantt.Entity.MauSac;
import com.duan.duantt.Entity.NguoiDung;
import com.duan.duantt.Repository.ChiTietDonHangRepository;
import com.duan.duantt.Repository.ChiTietSanPhamRepository;
import com.duan.duantt.Service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {

    @Autowired
    private ChiTietSanPhamRepository repository;

    @Override
    public List<String> findHinhAnhBySanPhamAndMauSac(UUID idSanPham, UUID idMauSac) {
        return repository.findHinhAnhBySanPhamAndMauSac(idSanPham, idMauSac);
    }


    @Override
    public List<MauSac> findDistinctColorsBySanPhamId(UUID sanPhamId) {
        return repository.findDistinctColorsBySanPhamId(sanPhamId);
    }
    @Override
    public List<KichThuoc> findDistinctSizesBySanPhamId(UUID sanPhamId) {
        return repository.findDistinctSizesBySanPhamId(sanPhamId);
    }

    @Override
    public List<ChiTietSanPham> findBySanPhamId(UUID idSanPham) {
        return repository.findBySanPhamId(idSanPham);
    }

    @Override
    public ChiTietSanPham findByMauSacIdAndKichThuocIdAndSanPhamId(UUID mauSacId, UUID kichThuocId, UUID sanPhamId) {
        return repository.findByMauSacIdAndKichThuocIdAndSanPhamId(mauSacId,kichThuocId,sanPhamId);
    }

    @Override
    public List<ChiTietSanPham> findChiTietSanPhamByMauSacAndSanPham(UUID mauSacId, UUID sanPhamId) {
        return repository.findChiTietSanPhamByMauSacAndSanPham(mauSacId,sanPhamId);
    }

    @Override
    public Optional<ChiTietSanPham> findById(UUID uuid) {
        Optional<ChiTietSanPham> chiTietSanPham = repository.findById(uuid);

        if (chiTietSanPham.isPresent()){
            return chiTietSanPham;
        }

        return Optional.empty();
    }

    @Override
    public ChiTietSanPham save(ChiTietSanPham chiTietSanPham) {
        return repository.save(chiTietSanPham);
    }
}
