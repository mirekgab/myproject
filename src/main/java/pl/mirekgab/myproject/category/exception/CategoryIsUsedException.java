package pl.mirekgab.myproject.category.exception;

import pl.mirekgab.myproject.errorhandler.AppRuntimeException;

public class CategoryIsUsedException extends AppRuntimeException {

    public CategoryIsUsedException(Long id) {
        super(String.format("category with id %d is used in products", id));
    }
}
