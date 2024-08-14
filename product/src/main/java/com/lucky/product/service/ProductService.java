package com.lucky.product.service;

import com.lucky.product.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAll();

    ProductDTO save(ProductDTO productDTO);

    ProductDTO update(ProductDTO productDTO);

    void delete(Integer id);
}
