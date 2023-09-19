package com.duan.duantt.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;


@Data
@Entity
@Table(name = "KhuyenMai")
public class KhuyenMai {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "GiaTri")
    private BigDecimal giaTri;

    @Column(name = "BatDau")
    private Date batDau;

    @Column(name = "KetThuc")
    private Date ketThuc;

    @Column(name = "TrangThai")
    private Boolean trangThai;

    // Getters and setters
}
