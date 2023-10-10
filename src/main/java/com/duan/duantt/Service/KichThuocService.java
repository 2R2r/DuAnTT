package com.duan.duantt.Service;

import com.duan.duantt.Entity.KichThuoc;
import com.duan.duantt.Entity.TheLoai;

import java.util.List;
import java.util.UUID;

public interface KichThuocService {

     List<KichThuoc> getAll();

     void add(KichThuoc kichThuoc);

     KichThuoc detail(UUID id);

     void delete(UUID id);


}