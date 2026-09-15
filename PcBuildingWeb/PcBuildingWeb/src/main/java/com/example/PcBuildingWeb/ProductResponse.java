package com.example.PcBuildingWeb;
import java.util.List;
public class ProductResponse {
    private boolean success;
    private int count;
    private List<Product> data;
    public ProductResponse() {
    }
    public boolean isSuccess() {
        return success;
    }
    public int getCount() {
        return count;
    }
    public List<Product> getData() {
        return data;
    }
}