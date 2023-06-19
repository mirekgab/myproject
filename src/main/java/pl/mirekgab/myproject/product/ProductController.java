package pl.mirekgab.myproject.product;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping
    public List<ProductDTO> getAllProduct(
            @RequestParam(name="page", defaultValue="0") int page,
            @RequestParam(name="size", defaultValue="0") int size
    ) {
        return productService.getAllProducts(page, size);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createNewProduct(@RequestBody CreateProductDTO newProduct) {
        return new ResponseEntity<>(productService.createProduct(newProduct), HttpStatus.CREATED);
    }

}
