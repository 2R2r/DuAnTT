package com.duan.duantt.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;


@Data
@Entity
@Table(name = "KichThuoc")
public class KichThuoc {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "TrangThai")
    private Boolean trangThai;

    // Getters and setters
}
