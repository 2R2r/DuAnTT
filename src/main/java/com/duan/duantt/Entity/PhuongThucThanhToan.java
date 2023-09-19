package com.duan.duantt.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;


@Data
@Entity
@Table(name = "PhuongThucThanhToan")
public class PhuongThucThanhToan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ten")
    private String ten;

    // Getters and setters
}
