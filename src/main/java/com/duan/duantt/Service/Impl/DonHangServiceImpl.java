package com.duan.duantt.Service.Impl;


import com.duan.duantt.Entity.ChiTietDonHang;
import com.duan.duantt.Entity.DonHang;
import com.duan.duantt.Repository.ChiTietDonHangRepository;
import com.duan.duantt.Repository.DonHangRepository;
import com.duan.duantt.Service.DonHangService;
import com.duan.duantt.Service.NguoiDungService;
import com.duan.duantt.security.AuthController;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DonHangServiceImpl implements DonHangService {

    @Autowired
    private DonHangRepository repository;

    @Autowired
    private AuthController authController;

    @Autowired
    private ChiTietDonHangRepository repository2;

    @Autowired
    private NguoiDungService nguoiDungService;

    public List<DonHang> getAll(){
        return repository.findAll();
    }


    public Optional<DonHang> findById(UUID id){
        return repository.findById(id);
    }


    public DonHang create(JsonNode orderData) {
        if (orderData == null) {
            throw new IllegalArgumentException("orderData cannot be null");
        }

        ObjectMapper mapper = new ObjectMapper();
        DonHang order = mapper.convertValue(orderData, DonHang.class);
        order.setNguoiDung(nguoiDungService.findByTaiKhoan(authController.getAuthentication().getName()).get());
        DonHang savedOrder = repository.save(order);

        JsonNode orderDetailsNode = orderData.get("chiTietDonHangs");
        if (orderDetailsNode != null && orderDetailsNode.isArray()) {
            TypeReference<List<ChiTietDonHang>> type = new TypeReference<>() {};
            List<ChiTietDonHang> details = mapper.convertValue(orderDetailsNode, type)
                    .stream().peek(d -> d.setDonHang(savedOrder)).collect(Collectors.toList());
            repository2.saveAll(details);
        } else {
            throw new IllegalArgumentException("orderDetails must be a non-null array");
        }

        return order;
    }


    @Override
    public List<DonHang> findByNguoiDungId(UUID nguoiDungId) {
        return repository.findByNguoiDungId(nguoiDungId);
    }

    @Override
    public DonHang save(DonHang donHang) {
        return repository.save(donHang);
    }
}
