package com.duan.duantt.Controller;

import com.duan.duantt.Entity.BaiViet;
import com.duan.duantt.Service.BaiVietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/baiviet/")
public class ViewBaiVietController {
    @Autowired
    private BaiVietService baiVietService;

    @GetMapping("hien-thi")
    public String listBaiViets1(Model model) {
        List<BaiViet> list = baiVietService.getAll();
        model.addAttribute("list", list);
        return "webbaiviet/list";
    }
}
