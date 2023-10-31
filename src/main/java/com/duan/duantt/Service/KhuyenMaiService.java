package com.duan.duantt.Service;

import com.duan.duantt.Entity.KhuyenMai;
import com.duan.duantt.Repository.KhuyenMaiRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public interface KhuyenMaiService {


    Optional<KhuyenMai>  findByMa(String maKm);
}
