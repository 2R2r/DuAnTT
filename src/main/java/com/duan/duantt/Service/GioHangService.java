package com.duan.duantt.Service;

import com.duan.duantt.Entity.GioHang;

import java.util.List;
import java.util.UUID;

public interface GioHangService {

    GioHang findByNguoiDungId(UUID nguoiDungId);

    GioHang save(GioHang gioHang);
}
