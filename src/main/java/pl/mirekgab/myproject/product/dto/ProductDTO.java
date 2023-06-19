package pl.mirekgab.myproject.product.dto;

import pl.mirekgab.myproject.category.dto.CategoryDTO;

import java.math.BigDecimal;

public record ProductDTO (Long id, String name, BigDecimal price, CategoryDTO category){
}
