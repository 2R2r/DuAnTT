package com.duan.duantt.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ChiTietSanPham")
public class ChiTietSanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;

    @Column(name = "GiaBan")
    private BigDecimal giaBan;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "HinhAnh")
    private String hinhAnh;

    @ManyToOne
    @JoinColumn(name = "IdSanPham")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "IdMauSac")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "IdKichThuoc")
    private KichThuoc kichThuoc;


    @Column(name = "TrangThai")
    private Boolean trangThai;

    @Override
    public String toString() {
        return "ChiTietSanPham{" +
                "id=" + id +
                ", giaNhap=" + giaNhap +
                ", giaBan=" + giaBan +
                ", soLuong=" + soLuong +
                ", hinhAnh='" + hinhAnh + '\'' +
                ", sanPham=" + sanPham +
                ", mauSac=" + mauSac +
                ", kichThuoc=" + kichThuoc +
                ", trangThai=" + trangThai +
                '}';
    }
}