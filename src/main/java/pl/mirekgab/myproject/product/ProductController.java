package pl.mirekgab.myproject.product;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.mirekgab.myproject.product.dto.CreateProductDTO;
import pl.mirekgab.myproject.product.dto.ProductDTO;
import pl.mirekgab.myproject.product.dto.UpdateProductDTO;

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

    @PutMapping
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody UpdateProductDTO updateProduct) {
        return new ResponseEntity<>(productService.updateProduct(updateProduct), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProduct(Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
