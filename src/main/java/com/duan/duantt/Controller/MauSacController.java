package com.duan.duantt.Controller;

import com.duan.duantt.Entity.MauSac;
import com.duan.duantt.Service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/mauSac/")
public class MauSacController {
    @Autowired
    private MauSacService mauSacService;

    @GetMapping("hien-thi")
    public String listMauSacs(Model model) {
        List<MauSac> mauSacs = mauSacService.getAll();
        model.addAttribute("mauSacs", mauSacs);
        return "mausac/list";
    }

//    @PostMapping("add")
//    public String addMauSac(@Validated @ModelAttribute("ms1") MauSac mauSac, BindingResult result, Model model) {
//
//        if (result.hasErrors()) {
//            return "mausac/mausac";
//        }
//        String ma = "MS" + new Random().nextInt(100000);
//        mauSac.setMaMauSac(ma);
//        mauSac.setNgayTao(new Date());
//        mauSac.setTrangThai(1);
//        model.addAttribute("ms1", mauSac);
//        mauSacService.add(mauSac);
//        return "redirect:/mau-sac/hien-thi";
//    }
}
