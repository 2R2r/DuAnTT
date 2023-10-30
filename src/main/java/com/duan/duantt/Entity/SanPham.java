package com.duan.duantt.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SanPham")
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ten")
    private String ten;

    @ManyToOne
    @JoinColumn(name = "IdNSX")
    private NSX nsx;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "TrangThai")
    private Boolean trangThai;

    @ManyToOne
    @JoinColumn(name = "IdTheLoai")
    private TheLoai theLoai;

    @Override
    public String toString() {
        return "SanPham{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                ", nsx=" + nsx +
                ", moTa='" + moTa + '\'' +
                ", trangThai=" + trangThai +
                ", theLoai=" + theLoai +
                '}';
    }
}