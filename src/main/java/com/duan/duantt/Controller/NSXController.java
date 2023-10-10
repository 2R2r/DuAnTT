package com.duan.duantt.Controller;

import com.duan.duantt.Entity.MauSac;
import com.duan.duantt.Entity.NSX;
import com.duan.duantt.Service.NSXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/nsx/")
public class NSXController {
    @Autowired
    private NSXService nsxService;

    @GetMapping("hien-thi")
    public String listNSX(Model model) {
        List<NSX> nsxs = nsxService.getAll();
        model.addAttribute("nsxs", nsxs);
        model.addAttribute("nsx1", new NSX());
        return "nsx/list";
    }

    @PostMapping("add")
    public String addNSX(@ModelAttribute("nsx1") NSX nsx, Model model) {
        List<NSX> nsxs = new ArrayList<>();
        model.addAttribute("nsx1", nsxs);
        nsxService.add(nsx);
        return "redirect:/nsx/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String deleteNSX(@PathVariable UUID id, RedirectAttributes redirectAttributes, Model model) {
        nsxService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete Success");
        return "redirect:/nsx/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String updateNSX(@PathVariable UUID id, Model model) {
        NSX nsx = nsxService.detail(id);
        model.addAttribute("nsx1", nsx);
        return "nsx/detail";
    }

    @PostMapping("update")
    public String updateMauSac(@ModelAttribute("nsx1") NSX nsx, Model model) {
        model.addAttribute("nsx1", nsx);
        nsxService.add(nsx);
        return "redirect:/nsx/hien-thi";
    }
}
