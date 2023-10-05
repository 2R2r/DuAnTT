package com.duan.duantt.Repository;

import com.duan.duantt.Entity.ChiTietDonHang;
import com.duan.duantt.Entity.ChiTietGioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface ChiTietGioHangRepository extends JpaRepository<ChiTietGioHang,UUID> {

    List<ChiTietGioHang> findAllByGioHang_Id(UUID idGioHang);

    void deleteAllByGioHang_Id(UUID idGioHang);

    void deleteById(UUID id);
}
