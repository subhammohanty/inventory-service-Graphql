package com.javatechie.service;

import com.javatechie.entity.Product;
import com.javatechie.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getAllProductsByCategory(String category){
        return productRepository.findByCategory(category);
    }

    public Product save(String name, String category, Float price, int stock){
        Product product = new Product(name, category, price, stock);
        return productRepository.save(product);
    }

    public Product updateStock(int id, int stock){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product is not present for id " + id));
        product.setStock(stock);
        return productRepository.save(product);
    }

    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }
}
