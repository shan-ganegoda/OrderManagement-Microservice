package com.lucky.product.util.mapper;

import com.lucky.product.dto.ProductDTO;
import com.lucky.product.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ObjectMapper {
    List<ProductDTO> productListToDtoList(List<Product> products);

    Product productDtoToProduct(ProductDTO productDTO);
}
