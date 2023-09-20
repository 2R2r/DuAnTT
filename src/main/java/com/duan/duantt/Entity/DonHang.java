package com.duan.duantt.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Data
@Entity
@Table(name = "DonHang")
public class DonHang {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "TongTienTT")
    private BigDecimal tongTienTT;

    @Column(name = "TongTienKhuyenMai")
    private BigDecimal tongTienKhuyenMai;

    @Column(name = "TongTien")
    private BigDecimal tongTien;

    @Column(name = "DiaChi")
    private String diaChi;

    @ManyToOne
    @JoinColumn(name = "IdNguoiDung")
    private NguoiDung nguoiDung;

    @ManyToOne
    @JoinColumn(name = "IdKhuyenMai")
    private KhuyenMai khuyenMai;

    @ManyToOne
    @JoinColumn(name = "IdPhuongThucThanhToan")
    private PhuongThucThanhToan phuongThucThanhToan;


    @JsonIgnore
    @OneToMany(mappedBy = "donHang", cascade = CascadeType.ALL)
    private List<ChiTietDonHang> chiTietDonHangs;

    // Getters and setters
}
