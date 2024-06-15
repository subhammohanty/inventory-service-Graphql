package com.javatechie.resources;

import com.javatechie.entity.Product;
import com.javatechie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
//@RequestMapping("/products")
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

//    @GetMapping
    @QueryMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

//    @GetMapping("/{category}")
    @QueryMapping
    public List<Product> getAllProductsByCategory(@Argument String category){
        return productService.getAllProductsByCategory(category);
    }

    @MutationMapping
    public Product createProduct(@Argument String name, @Argument String category, @Argument Float price, @Argument int stock){
        return productService.save(name, category, price, stock);
    }

    @MutationMapping
    public Product updateStock(@Argument int id, @Argument int stock){
        return productService.updateStock(id, stock);
    }

    @MutationMapping
    public void deleteProduct(@Argument int id){
        productService.deleteProduct(id);
    }
}

