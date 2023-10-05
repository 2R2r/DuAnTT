package com.duan.duantt.ViewModel;

import com.duan.duantt.Entity.NSX;
import com.duan.duantt.Entity.TheLoai;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ViewSanPham {

    private UUID id;

    private String ten;

    private String hinhAnh;

    private BigDecimal giaBan;

    private NSX nsx;

    private String moTa;

    private TheLoai theLoai;

    @Override
    public String toString() {
        return "ViewSanPham{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                ", hinhAnh='" + hinhAnh + '\'' +
                ", giaBan=" + giaBan +
                ", nsx=" + nsx +
                ", moTa='" + moTa + '\'' +
                ", theLoai=" + theLoai +
                '}';
    }
}