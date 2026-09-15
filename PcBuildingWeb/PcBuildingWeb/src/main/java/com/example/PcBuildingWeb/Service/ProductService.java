package com.example.PcBuildingWeb.Service;
import com.example.PcBuildingWeb.Product;
import com.example.PcBuildingWeb.ProductResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import java.util.List;



@Service
public class ProductService {
    private final RestClient restClient = RestClient.create();
    public List<Product> getProducts(String category) {
        ProductResponse response = restClient.get()
                .uri("https://pc-builder-api-eabc.onrender.com/api/products")
                .retrieve()
                .body(ProductResponse.class);
        return response.getData()
                .stream()
                .filter(product ->
                        product.getCategory().equalsIgnoreCase(category))
                .toList();
    }
}