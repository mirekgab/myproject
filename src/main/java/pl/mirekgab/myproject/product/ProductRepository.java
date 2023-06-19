package pl.mirekgab.myproject.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long>{

    @Query(value = "select count(1) from Product p where p.category.id=:categoryId")
    Long usedCategoryId(@Param("categoryId") Long id);

}
