package com.duan.duantt.Controller;

import com.duan.duantt.Entity.MauSac;
import com.duan.duantt.Service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Controller
@RequestMapping("/mau-sac/")
public class MauSacController {
    @Autowired
    private MauSacService mauSacService;


    @GetMapping("hien-thi")
    public String listMauSacs(Model model) {
        List<MauSac> mauSacs = mauSacService.getAll();
        model.addAttribute("mauSacs", mauSacs);
        model.addAttribute("ms1", new MauSac());
        return "mausac/list";
    }

    @PostMapping("add")
    public String addMauSac(@ModelAttribute("ms1") MauSac mauSac, Model model) {
        List<MauSac> mauSacs = new ArrayList<>();
        model.addAttribute("ms1", mauSacs);
        mauSacService.add(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }
    @GetMapping("delete/{id}")
    public String deleteMauSac(@PathVariable UUID id, RedirectAttributes redirectAttributes , Model model) {
        mauSacService.delete(id);
        redirectAttributes.addFlashAttribute("message","Delete Success");
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String updateMauSac(@PathVariable UUID id, Model model) {
        MauSac mauSac = mauSacService.detail(id);
        model.addAttribute("ms1", mauSac);
        return "mausac/detail";
    }

    @PostMapping("update")
    public String updateMauSac(@ModelAttribute("ms1") MauSac mauSac, Model model) {
        model.addAttribute("ms1", mauSac);
        mauSacService.add(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }
}
