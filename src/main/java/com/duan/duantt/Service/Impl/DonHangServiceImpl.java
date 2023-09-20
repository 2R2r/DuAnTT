package com.duan.duantt.Service.Impl;


import com.duan.duantt.Entity.ChiTietDonHang;
import com.duan.duantt.Entity.DonHang;
import com.duan.duantt.Repository.ChiTietDonHangRepository;
import com.duan.duantt.Repository.DonHangRepository;
import com.duan.duantt.Service.DonHangService;
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
    private ChiTietDonHangRepository repository2;


    public List<DonHang> getAll(){
        return repository.findAll();
    }


    public Optional<DonHang> findById(UUID id){
        return repository.findById(id);
    }


    public DonHang create(JsonNode orderData) {
        ObjectMapper mapper = new ObjectMapper();

        DonHang order = mapper.convertValue(orderData,DonHang.class);
        DonHang savedOrder = repository.save(order);
        TypeReference<List<ChiTietDonHang>> type = new TypeReference<>() {
        };
        List<ChiTietDonHang> details = mapper.convertValue(orderData.get("orderDetails"),type)
                .stream().peek(d -> d.setDonHang(savedOrder)).collect(Collectors.toList());

        System.out.println(details);
        repository2.saveAll(details);
        return  order;
    }
}
