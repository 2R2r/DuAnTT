package com.duan.duantt.Repository;

import com.duan.duantt.Entity.KichThuoc;
import com.duan.duantt.Entity.MauSac;
import com.duan.duantt.Entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface KichThuocRepository extends JpaRepository<KichThuoc,UUID > {
    KichThuoc getKichThuocById(UUID id);
}
