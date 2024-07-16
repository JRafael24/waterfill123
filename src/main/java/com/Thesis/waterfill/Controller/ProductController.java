package com.Thesis.waterfill.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Thesis.waterfill.Model.Product;
import com.Thesis.waterfill.NotFoundException.ProductNotFoundException;
import com.Thesis.waterfill.Repository.ProductRepository;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    
    ProductRepository repo;
    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    //127.0.0.1:8080/products
    @GetMapping("/all")
    public List <Product>getProducts() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new ProductNotFoundException(id));
    }

    //127.0.0.1:800/product
    @GetMapping("/new")
    public String addProduct(@RequestBody Product newProduct) {
        repo.save(newProduct);
        return "A new Product Is Added!";
    }

    //update endpoints
    //127.0.0.1:8080/product/edit/{id}
    @PutMapping("/edit/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product newProduct) {
        return repo.findById(id)
        .map(product->{
            product.setProductName(newProduct.getProductName());
            product.setDescription(newProduct.getDescription());
            product.setPrice(newProduct.getPrice());
            product.setUrl(newProduct.getUrl());
            return repo.save(product);
        }).orElseGet(()->{
            return repo.save(newProduct);
        });
    }
    //delete endpoints
    //127.0.0.1:8080/product/delete/{id}
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        repo.deleteById(id);
        return "The Product Is Deleted";
    }

}
