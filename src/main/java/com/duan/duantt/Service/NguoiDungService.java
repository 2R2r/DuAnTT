package com.duan.duantt.Service;

import com.duan.duantt.Entity.NguoiDung;

import java.util.Optional;
import java.util.UUID;

public interface NguoiDungService {

    Optional<NguoiDung>  findById(UUID uuid);
}
