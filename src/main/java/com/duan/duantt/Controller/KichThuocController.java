package com.duan.duantt.Controller;

import com.duan.duantt.Entity.KichThuoc;
import com.duan.duantt.Entity.MauSac;
import com.duan.duantt.Service.KichThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/kich-thuoc/")
public class KichThuocController {
    @Autowired
    private KichThuocService kichThuocService;

    @GetMapping("hien-thi")
    public String listKichThuocc(Model model) {
        List<KichThuoc> kichThuocs = kichThuocService.getAll();
        model.addAttribute("kichThuocs", kichThuocs);
        model.addAttribute("kt1", new KichThuoc());
        return "kichthuoc/list";
    }

    @PostMapping("add")
    public String addKichThuoc(@ModelAttribute("kt1") KichThuoc kichThuoc, Model model){
        List<KichThuoc> kichThuocs= new ArrayList<>();
        model.addAttribute("kt1",kichThuocs);
        kichThuocService.add(kichThuoc);
        return "redirect:/kich-thuoc/hien-thi";

    }
    @GetMapping("delete/{id}")
    public String deleteMauSac(@PathVariable UUID id, RedirectAttributes redirectAttributes , Model model) {
        kichThuocService.delete(id);
        redirectAttributes.addFlashAttribute("message","Delete Success");
        return "redirect:/kich-thuoc/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String updateMauSac(@PathVariable UUID id, Model model) {
        KichThuoc kichThuoc = kichThuocService.detail(id);
        model.addAttribute("kt1", kichThuoc);
        return "kichthuoc/detail";
    }


    @PostMapping("update")
    public String updateKichThuoc(@ModelAttribute("kt1") KichThuoc kichThuoc, Model model){
        List<KichThuoc> kichThuocs= new ArrayList<>();
        model.addAttribute("kt1",kichThuocs);
        kichThuocService.add(kichThuoc);
        return "redirect:/kich-thuoc/hien-thi";

    }

}
