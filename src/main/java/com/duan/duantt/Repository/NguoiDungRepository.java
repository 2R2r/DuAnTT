package com.duan.duantt.Repository;

import com.duan.duantt.Entity.ChiTietDonHang;
import com.duan.duantt.Entity.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDung,UUID> {
    Optional<NguoiDung> findByTaiKhoan(String username);

}
