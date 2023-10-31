package com.duan.duantt.Repository;

import com.duan.duantt.Entity.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface DonHangRepository extends JpaRepository<DonHang,UUID> {

    List<DonHang> findByNguoiDungId(UUID nguoiDungId);
}
