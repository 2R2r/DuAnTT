package com.duan.duantt.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;


@Data
@Entity
@Table(name = "VaiTro")
public class VaiTro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "TenVaiTro")
    private String tenVaiTro;

    @Column(name = "TrangThai")
    private Integer trangThai;

    // Getters and setters
}
