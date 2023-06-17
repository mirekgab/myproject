package pl.mirekgab.myproject.product;

import pl.mirekgab.myproject.category.CategoryDTO;

import java.math.BigDecimal;

public record ProductDTO (Long id, String name, BigDecimal price, CategoryDTO category){
}
