package com.duan.duantt.Service.Impl;


import com.duan.duantt.Repository.KhuyenMaiRepository;
import com.duan.duantt.Repository.NguoiDungRepository;
import com.duan.duantt.Service.KhuyenMaiService;
import com.duan.duantt.Service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhuyenMaiServiceImpl implements KhuyenMaiService {

    @Autowired
    private KhuyenMaiRepository repository;
}
