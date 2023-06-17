package pl.mirekgab.myproject.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductDTO> findAll() {
        List<Product> list = productRepository.findAll();
        return list.stream().map(productMapper::mapEntityToDTO).toList();
    }

}
