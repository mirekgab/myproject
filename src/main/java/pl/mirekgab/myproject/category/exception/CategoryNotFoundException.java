package pl.mirekgab.myproject.category.exception;

import pl.mirekgab.myproject.errorhandler.AppRuntimeException;

public class CategoryNotFoundException extends AppRuntimeException {

    public CategoryNotFoundException(Long id) {
        super(String.format("category with id %d not exist", id));
    }
}
