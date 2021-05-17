package com.demo.ecommerce.controller;

import com.demo.ecommerce.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class WelcomeController {

    // inject via application.properties
    @Value("${welcome.message}")
    private String message;

    private List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);

        return "welcome"; //view
    }

    // /hello?name=kotlin
    @GetMapping("/hello")
    public String mainWithParam(
            @RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {

        model.addAttribute("message", name);

        return "welcome"; //view
    }

    @GetMapping("/getProducts")
    public String getProducts(Model model) {
        List<Product> productList = new ArrayList<>();
        Product p1 = new Product(1, "Producto1");
        Product p2 = new Product(1, "Producto1");
        Product p3 = new Product(1, "Producto1");
        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        model.addAttribute("productList", productList);

        return "productList"; //view
    }

}