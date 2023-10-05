package com.duan.duantt.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller

public class OrderController {

    @GetMapping("/order/checkout")
    public String checkout(){
        return "order/checkout";
    }

    @GetMapping("/order/list")
    public String list(){
        return "order/list";
    }

    @GetMapping("/order/detail/{id}")
    public String detail(){
        return "order/detail";
    }
}
