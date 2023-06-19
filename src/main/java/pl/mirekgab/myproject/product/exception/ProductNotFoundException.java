package pl.mirekgab.myproject.product.exception;

import pl.mirekgab.myproject.errorhandler.AppRuntimeException;

public class ProductNotFoundException extends AppRuntimeException {
    public ProductNotFoundException(Long id) {
        super(String.format("product with id %d not exist", id));
    }
}
