package com.duan.duantt.Service;


import com.duan.duantt.Entity.NSX;

import java.util.List;
import java.util.UUID;

public interface NSXService {
    List<NSX> getAll();

    void add(NSX nsx);

    NSX detail(UUID id);

    void delete(UUID id);
}
