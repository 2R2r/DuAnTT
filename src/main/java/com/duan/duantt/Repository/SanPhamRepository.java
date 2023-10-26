package com.duan.duantt.Repository;

import com.duan.duantt.Entity.DonHang;
import com.duan.duantt.Entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface SanPhamRepository extends JpaRepository<SanPham,UUID > {

    List<SanPham> findByTheLoaiId(UUID cateId);
    List<SanPham> findByTenContaining(String ten);
}
