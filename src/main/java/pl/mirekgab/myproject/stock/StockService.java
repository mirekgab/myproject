package pl.mirekgab.myproject.stock;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StockService {
    private final StockRepository stockRepository;
    private final StockMapper stockMapper;

    public List<StockDTO> getAllStocks(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Stock> allStocks = stockRepository.findAll(pageable);

        return allStocks.stream().map(stockMapper::mapEntityToDTO).toList();
    }
}
