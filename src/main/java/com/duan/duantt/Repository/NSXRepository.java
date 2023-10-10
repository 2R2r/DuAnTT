package com.duan.duantt.Repository;

import com.duan.duantt.Entity.MauSac;
import com.duan.duantt.Entity.NSX;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NSXRepository extends JpaRepository<NSX, UUID> {
    NSX getNSXById(UUID id);
}
