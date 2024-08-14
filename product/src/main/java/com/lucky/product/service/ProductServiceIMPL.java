package com.lucky.product.service;

import com.lucky.product.dto.ProductDTO;
import com.lucky.product.entity.Product;
import com.lucky.product.repository.ProductRepository;
import com.lucky.product.util.mapper.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceIMPL implements ProductService {

    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;

    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();
        if(!products.isEmpty()) {
            return objectMapper.productListToDtoList(products);
        }else{
            return null;
        }
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = objectMapper.productDtoToProduct(productDTO);
        productRepository.save(product);
        return productDTO;
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        if(productRepository.existsById(productDTO.getId())) {
            Product product = objectMapper.productDtoToProduct(productDTO);
            productRepository.save(product);
            return productDTO;
        }else{
            return null;
        }
    }

    @Override
    public void delete(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(null);
        productRepository.delete(product);
    }
}
