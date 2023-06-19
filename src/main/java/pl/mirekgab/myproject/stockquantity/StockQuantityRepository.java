package pl.mirekgab.myproject.stockquantity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockQuantityRepository extends JpaRepository<StockQuantity, Long> {
    Optional<StockQuantity> findByStockIdAndProductId(Long stockId, Long productId);
}