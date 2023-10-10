package com.duan.duantt.Service;

import com.duan.duantt.Entity.SanPham;
import com.duan.duantt.Entity.TheLoai;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TheLoaiService {

     List<TheLoai> getAll();

     void add(TheLoai theLoai);

     TheLoai detail(UUID id);

     void delete(UUID id);


}