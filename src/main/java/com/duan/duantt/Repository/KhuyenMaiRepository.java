package com.duan.duantt.Repository;

import com.duan.duantt.Entity.ChiTietDonHang;
import com.duan.duantt.Entity.KhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface KhuyenMaiRepository extends JpaRepository<KhuyenMai,UUID> {
}
