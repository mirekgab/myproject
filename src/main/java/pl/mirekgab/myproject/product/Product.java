package pl.mirekgab.myproject.product;

import lombok.Getter;
import lombok.Setter;
import pl.mirekgab.myproject.category.Category;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
