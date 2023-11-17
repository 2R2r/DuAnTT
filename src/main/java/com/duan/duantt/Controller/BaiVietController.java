package com.duan.duantt.Controller;

import com.duan.duantt.Entity.BaiViet;
import com.duan.duantt.Entity.ChiTietSanPham;
import com.duan.duantt.Entity.MauSac;
import com.duan.duantt.Service.BaiVietService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/bai-viet/")
public class BaiVietController {
    @Autowired
    private BaiVietService baiVietService;

    @GetMapping("hien-thi")
    public String listBaiViets(Model model) {
        List<BaiViet> baiViets = baiVietService.getAll();
        model.addAttribute("list", baiViets);
        model.addAttribute("bv1", new BaiViet());
        return "baiviet/list";
    }

    @PostMapping("add")
    public String add(@ModelAttribute("bv1") BaiViet baiViet, Model model, HttpSession session){
        baiVietService.add(baiViet);
        session.setAttribute("successMessage", "Thêm thành công");
        return "redirect:/admin/bai-viet/hien-thi";

    }
    @GetMapping("delete/{id}")
    public String deleteMauSac(@PathVariable UUID id, RedirectAttributes redirectAttributes , Model model) {
        baiVietService.delete(id);
        redirectAttributes.addFlashAttribute("message","Delete Success");
        return "redirect:/admin/bai-viet/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String updateMauSac(@PathVariable UUID id, Model model) {
        BaiViet baiViet = baiVietService.detail(id);
        model.addAttribute("bv1", baiViet);
        return "baiviet/detail";
    }

    @PostMapping("update")
    public String updateMauSac(@ModelAttribute("bv1") BaiViet baiViet, Model model) {
        model.addAttribute("bv1", baiViet);
        baiVietService.add(baiViet);
        return "redirect:/admin/bai-viet/hien-thi";
    }
}
