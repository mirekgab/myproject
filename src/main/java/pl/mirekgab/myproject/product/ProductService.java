package pl.mirekgab.myproject.product;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.mirekgab.myproject.category.Category;
import pl.mirekgab.myproject.category.CategoryRepository;
import pl.mirekgab.myproject.errorhandler.AppRuntimeException;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

    public List<ProductDTO> getAllProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> allProducts = productRepository.findAll(pageable);

        return allProducts.stream().map(productMapper::mapEntityToDTO).toList();
    }

    public ProductDTO createProduct(CreateProductDTO newProduct) {
        if (newProduct==null) {
            throw new AppRuntimeException("product is null");
        }
        Category category = categoryRepository.findById(newProduct.categoryId()).orElseThrow(
                () -> new AppRuntimeException(String.format("category with id %d not exist", newProduct.categoryId()))
        );
        Product product = new Product.ProductBuilder()
                .category(category)
                .name(newProduct.name())
                .price(newProduct.price())
                .build();
        return productMapper.mapEntityToDTO(productRepository.save(product));
    }

}
