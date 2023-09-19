package com.duan.duantt.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;


@Data
@Entity
@Table(name = "BaiViet")
public class BaiViet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "TieuDe")
    private String tieuDe;

    @Column(name = "NoiDung")
    private String noiDung;

    @Column(name = "HinhAnh")
    private String hinhAnh;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @ManyToOne
    @JoinColumn(name = "IdNguoiDung")
    private NguoiDung nguoiDung;

    @Column(name = "TrangThai")
    private Boolean trangThai;

    // Getters and setters
}
