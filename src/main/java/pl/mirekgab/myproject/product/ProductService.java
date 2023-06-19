package pl.mirekgab.myproject.product;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.mirekgab.myproject.category.Category;
import pl.mirekgab.myproject.category.CategoryRepository;
import pl.mirekgab.myproject.category.exception.CategoryNotFoundException;
import pl.mirekgab.myproject.errorhandler.AppRuntimeException;
import pl.mirekgab.myproject.product.dto.CreateProductDTO;
import pl.mirekgab.myproject.product.dto.ProductDTO;
import pl.mirekgab.myproject.product.dto.UpdateProductDTO;
import pl.mirekgab.myproject.product.exception.ProductNotFoundException;

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
        if (newProduct == null) {
            throw new AppRuntimeException("product is null");
        }
        Category category = categoryRepository.findById(newProduct.categoryId()).orElseThrow(
                () -> new CategoryNotFoundException(newProduct.categoryId())
        );
        Product product = new Product.ProductBuilder()
                .category(category)
                .name(newProduct.name())
                .price(newProduct.price())
                .build();
        return productMapper.mapEntityToDTO(productRepository.save(product));
    }

    public ProductDTO updateProduct(UpdateProductDTO updateProduct) {
        Product product = productRepository.findById(updateProduct.id()).orElseThrow(
                () -> new ProductNotFoundException(updateProduct.id()));

        Category category = categoryRepository.findById(updateProduct.categoryId()).orElseThrow(() ->
                new CategoryNotFoundException(updateProduct.categoryId()));

        product.setName(updateProduct.name());
        product.setCategory(category);

        return productMapper.mapEntityToDTO(productRepository.save(product));
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
    }
}
