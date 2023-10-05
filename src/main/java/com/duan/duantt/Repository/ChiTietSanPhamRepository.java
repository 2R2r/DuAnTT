package com.duan.duantt.Repository;

import com.duan.duantt.Entity.ChiTietDonHang;
import com.duan.duantt.Entity.ChiTietSanPham;
import com.duan.duantt.Entity.KichThuoc;
import com.duan.duantt.Entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface ChiTietSanPhamRepository extends JpaRepository<ChiTietSanPham,UUID> {


    @Query("SELECT c.hinhAnh FROM ChiTietSanPham c WHERE c.sanPham.id = :idSanPham AND c.mauSac.id = :idMauSac GROUP BY c.hinhAnh")
    List<String> findHinhAnhBySanPhamAndMauSac(UUID idSanPham, UUID idMauSac);


    @Query("SELECT c.hinhAnh FROM ChiTietSanPham c WHERE c.mauSac.id = :colorId AND c.sanPham.id = :productId GROUP BY c.hinhAnh")
    String findHinhAnhByColorIdAndSanPhamId(UUID colorId, UUID productId);


    @Query("SELECT c FROM ChiTietSanPham c WHERE c.mauSac.id = :mauSacId AND c.sanPham.id = :sanPhamId")
    List<ChiTietSanPham> findChiTietSanPhamByMauSacAndSanPham(@Param("mauSacId") UUID mauSacId, @Param("sanPhamId") UUID sanPhamId);

    @Query("SELECT c.mauSac FROM ChiTietSanPham c WHERE c.sanPham.id = :sanPhamId GROUP BY c.mauSac")
    List<MauSac> findDistinctColorsBySanPhamId(@Param("sanPhamId") UUID sanPhamId);

    @Query("SELECT c.kichThuoc FROM ChiTietSanPham c WHERE c.sanPham.id = :sanPhamId GROUP BY c.kichThuoc")
    List<KichThuoc> findDistinctSizesBySanPhamId(@Param("sanPhamId") UUID sanPhamId);


    List<ChiTietSanPham> findBySanPhamId(UUID idSanPham);

    ChiTietSanPham findByMauSacIdAndKichThuocIdAndSanPhamId(UUID mauSacId, UUID kichThuocId, UUID sanPhamId);

}
