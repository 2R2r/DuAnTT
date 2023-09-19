package com.duan.duantt.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;


@Data
@Entity
@Table(name = "SanPham")
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;

    @Column(name = "GiaBan")
    private BigDecimal giaBan;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "HinhAnh")
    private String hinhAnh;

    @ManyToOne
    @JoinColumn(name = "IdNSX")
    private NSX nsx;

    @Column(name = "TrangThai")
    private Boolean trangThai;

    @Column(name = "MoTa")
    private String moTa;

    @ManyToOne
    @JoinColumn(name = "IdTheLoai")
    private TheLoai theLoai;

    @ManyToOne
    @JoinColumn(name = "IdMauSac")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "IdKichCo")
    private KichThuoc kichThuoc;

    // Getters and setters
}
