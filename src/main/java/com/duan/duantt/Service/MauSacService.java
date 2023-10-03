package com.duan.duantt.Service;

import com.duan.duantt.Entity.MauSac;
import com.duan.duantt.Entity.TheLoai;

import java.util.List;
import java.util.UUID;

public interface MauSacService {

     List<MauSac> getAll();

     void add(MauSac mauSac);

     MauSac detail(UUID id);

     void delete(UUID id);


}