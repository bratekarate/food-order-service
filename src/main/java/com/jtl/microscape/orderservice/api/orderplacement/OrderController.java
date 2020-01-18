package com.jtl.microscape.orderservice.api.orderplacement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("")
    public String orders() {
        return "list of orders!";
    }

}
