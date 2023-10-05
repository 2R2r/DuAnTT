package com.duan.duantt.Service.Impl;

import com.duan.duantt.Entity.ChiTietSanPham;
import com.duan.duantt.Entity.SanPham;
import com.duan.duantt.Repository.ChiTietSanPhamRepository;
import com.duan.duantt.Repository.DonHangRepository;
import com.duan.duantt.Repository.SanPhamRepository;
import com.duan.duantt.Service.SanPhamService;
import com.duan.duantt.ViewModel.ViewSanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    private SanPhamRepository repository;

    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;

    public ViewSanPham convertSanPhamToViewSanPham(SanPham sanPham, ChiTietSanPham chiTietSanPhamList) {
        ViewSanPham viewSanPham = new ViewSanPham();
        viewSanPham.setTen(sanPham.getTen());

        // Lấy hình ảnh và giá bán từ chi tiết sản phẩm đầu tiên trong danh sách
        if (chiTietSanPhamList != null) {
            viewSanPham.setHinhAnh(chiTietSanPhamList.getHinhAnh());
            viewSanPham.setGiaBan(chiTietSanPhamList.getGiaBan());
        }

        viewSanPham.setId(sanPham.getId());
        viewSanPham.setNsx(sanPham.getNsx());
        viewSanPham.setMoTa(sanPham.getMoTa());
        viewSanPham.setTheLoai(sanPham.getTheLoai());

        return viewSanPham;
    }

    public List<SanPham> getAll() {
        return repository.findAll();
    }

    @Override
    public List<ViewSanPham> getAllViewSanPham() {
        List<SanPham> sanPhamList = repository.findAll();
        List<ViewSanPham> viewSanPhamList = new ArrayList<>();

        for (SanPham sanPham : sanPhamList) {
            List<ChiTietSanPham> chiTietSanPhamList = chiTietSanPhamRepository.findBySanPhamId(sanPham.getId());

            // Lọc ra các ChiTietSanPham và SanPham có TrangThai = true
            chiTietSanPhamList = chiTietSanPhamList.stream()
                    .filter(chiTietSanPham -> chiTietSanPham.getTrangThai())
                    .collect(Collectors.toList());

            if (!chiTietSanPhamList.isEmpty()) {
                ViewSanPham viewSanPham = convertSanPhamToViewSanPham(sanPham, chiTietSanPhamList.get(0));
                viewSanPhamList.add(viewSanPham);
            }
        }

        return viewSanPhamList;
    }



    public Optional<ViewSanPham> findById(UUID id) {
        Optional<SanPham> sanPhamOptional = repository.findById(id);

        if (sanPhamOptional.isPresent()) {
            SanPham sanPham = sanPhamOptional.get();
            List<ChiTietSanPham> chiTietSanPhamList = chiTietSanPhamRepository.findBySanPhamId(id);

            // Lọc ra các ChiTietSanPham và SanPham có TrangThai = true
            chiTietSanPhamList = chiTietSanPhamList.stream()
                    .filter(chiTietSanPham -> chiTietSanPham.getTrangThai())
                    .collect(Collectors.toList());

            if (!chiTietSanPhamList.isEmpty()) {
                return Optional.of(convertSanPhamToViewSanPham(sanPham, chiTietSanPhamList.get(0)));
            }
        }

        return Optional.empty();
    }



    public List<ViewSanPham> findByTheLoaiId(UUID id) {
        List<SanPham> sanPhamList = repository.findByTheLoaiId(id);
        List<ViewSanPham> viewSanPhamList = new ArrayList<>();

        for (SanPham sanPham : sanPhamList) {
            List<ChiTietSanPham> chiTietSanPhamList = chiTietSanPhamRepository.findBySanPhamId(sanPham.getId());

            // Lọc ra các ChiTietSanPham và SanPham có TrangThai = true
            chiTietSanPhamList = chiTietSanPhamList.stream()
                    .filter(chiTietSanPham -> chiTietSanPham.getTrangThai())
                    .collect(Collectors.toList());

            if (!chiTietSanPhamList.isEmpty()) {
                ViewSanPham viewSanPham = convertSanPhamToViewSanPham(sanPham, chiTietSanPhamList.get(0));
                viewSanPhamList.add(viewSanPham);
            }
        }

        return viewSanPhamList;
    }


}
