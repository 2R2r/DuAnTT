package com.duan.duantt.Repository;

import com.duan.duantt.Entity.ChiTietDonHang;
import com.duan.duantt.Entity.TheLoai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface TheLoaiRepository extends JpaRepository<TheLoai,UUID> {
}
