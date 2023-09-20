package com.duan.duantt.Repository;

import com.duan.duantt.Entity.ChiTietDonHang;
import com.duan.duantt.Entity.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface ChiTietDonHangRepository extends JpaRepository<ChiTietDonHang,UUID> {
}
