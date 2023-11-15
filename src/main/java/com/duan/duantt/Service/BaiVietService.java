package com.duan.duantt.Service;

import com.duan.duantt.Entity.BaiViet;

import java.util.List;
import java.util.UUID;

public interface BaiVietService {

    List<BaiViet> getAll();

    void add(BaiViet baiViet);

    BaiViet detail(UUID id);

    void delete(UUID id);
}
