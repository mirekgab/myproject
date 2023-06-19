package pl.mirekgab.myproject.product;

import java.math.BigDecimal;

public record CreateProductDTO (String name, BigDecimal price, Long categoryId) {
}
