package com.example.PcBuildingWeb.Controller;
import com.example.PcBuildingWeb.Product;
import com.example.PcBuildingWeb.Service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;



@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts(@RequestParam String category) {

        return productService.getProducts(category);
    }
}
