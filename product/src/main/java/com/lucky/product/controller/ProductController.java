package com.lucky.product.controller;

import com.lucky.product.dto.ProductDTO;
import com.lucky.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDTO> getAll(){
        return productService.getAll();
    }

    @PostMapping
    public ProductDTO create(@RequestBody ProductDTO productDTO){
        return productService.save(productDTO);
    }

    @PutMapping
    public ProductDTO update(@RequestBody ProductDTO productDTO){
        return productService.update(productDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        productService.delete(id);
    }
}
