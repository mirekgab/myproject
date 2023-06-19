package pl.mirekgab.myproject.stock;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@AllArgsConstructor
public class StockController {
    private final StockService stockService;

    @GetMapping
    public List<StockDTO> getAllStocks(
            @RequestParam(name="page", defaultValue="0") int page,
            @RequestParam(name="size", defaultValue="0") int size
    ) {
        return stockService.getAllStocks(page, size);
    }
}
