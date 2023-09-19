package com.duan.duantt.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;


@Data
@Entity
@Table(name = "ChiTietDonHang")
public class ChiTietDonHang {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Gia")
    private BigDecimal gia;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @ManyToOne
    @JoinColumn(name = "IdDonHang")
    private DonHang donHang;

    @ManyToOne
    @JoinColumn(name = "IdSanPham")
    private SanPham sanPham;

    // Getters and setters
}
