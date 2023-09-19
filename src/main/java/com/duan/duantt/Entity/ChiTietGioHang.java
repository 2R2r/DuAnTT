package com.duan.duantt.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;


@Data
@Entity
@Table(name = "ChiTietGioHang")
public class ChiTietGioHang {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "IdGioHang")
    private GioHang gioHang;

    @ManyToOne
    @JoinColumn(name = "IdSanPham")
    private SanPham sanPham;

    @Column(name = "SoLuong")
    private Integer soLuong;

    // Getters and setters
}
