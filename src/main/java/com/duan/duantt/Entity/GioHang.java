package com.duan.duantt.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;


@Data
@Entity
@Table(name = "GioHang")
public class GioHang {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "IdNguoiDung")
    private NguoiDung nguoiDung;

    // Getters and setters
}
