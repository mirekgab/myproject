package pl.mirekgab.myproject.product.dto;

import java.math.BigDecimal;

public record CreateProductDTO (String name, BigDecimal price, Long categoryId) {
}
