package com.duan.duantt.Repository;

import com.duan.duantt.Entity.ChiTietGioHang;
import com.duan.duantt.Entity.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface GioHangRepository extends JpaRepository<GioHang,UUID> {

    GioHang findByNguoiDungId(UUID nguoiDungId);
}
