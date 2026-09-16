package com.example.PcBuildingWeb.Controller;

import com.example.PcBuildingWeb.Service.ExternalProductService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ExternalProductService externalProductService;

    public ProductController(
            ExternalProductService externalProductService
    ) {
        this.externalProductService =
                externalProductService;
    }

    @GetMapping
    public String getProducts() {

        return externalProductService.getProducts();

    }
}