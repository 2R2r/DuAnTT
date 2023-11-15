package com.duan.duantt.Repository;

import com.duan.duantt.Entity.BaiViet;
import com.duan.duantt.Entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BaiVietRepository extends JpaRepository<BaiViet, UUID> {
    BaiViet getBaiVietById(UUID id);
}
