package com.duan.duantt.Service;

import com.duan.duantt.Entity.DonHang;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DonHangService {


    List<DonHang> getAll();


    Optional<DonHang> findById(UUID id);


    DonHang create(JsonNode orderData);

    List<DonHang> findByNguoiDungId(UUID nguoiDungId);
}
