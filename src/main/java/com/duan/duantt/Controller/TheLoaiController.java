package com.duan.duantt.Controller;

import com.duan.duantt.Entity.NSX;
import com.duan.duantt.Entity.TheLoai;
import com.duan.duantt.Service.TheLoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/the-loai/")
public class TheLoaiController {
    @Autowired
    private TheLoaiService theLoaiService;

    @GetMapping("hien-thi")
    public String listTheLoai(Model model){
        List<TheLoai> theLoais = theLoaiService.getAll();
        model.addAttribute("theLoais",theLoais);
        model.addAttribute("tl1",new TheLoai());
        return "theloai/list";
    }

    @PostMapping("add")
    public String addTheLoai(@ModelAttribute("tl1") TheLoai theLoai, Model model) {
        List<TheLoai> theLoais = new ArrayList<>();
        model.addAttribute("tl1", theLoais);
        theLoaiService.add(theLoai);
        return "redirect:/the-loai/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String deleteNSX(@PathVariable UUID id, RedirectAttributes redirectAttributes, Model model) {
        theLoaiService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete Success");
        return "redirect:/the-loai/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String updateNSX(@PathVariable UUID id, Model model) {
        TheLoai theLoai = theLoaiService.detail(id);
        model.addAttribute("tl1", theLoai);
        return "theloai/detail";
    }

    @PostMapping("update")
    public String updateMauSac(@ModelAttribute("tl1") TheLoai theLoai, Model model) {
        model.addAttribute("tl1", theLoai);
        theLoaiService.add(theLoai);
        return "redirect:/the-loai/hien-thi";
    }
}
