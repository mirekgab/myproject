package pl.mirekgab.myproject.category;

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

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> getAllCategories(@RequestParam(name="page", defaultValue = "0") int page,
                                              @RequestParam(name="size", defaultValue = "100") int size) {
        return categoryService.getAllCategories(page, size);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createNewCategory(@RequestBody CreateCategoryDTO newCategory) {
        return new ResponseEntity<>(categoryService.createNewCategory(newCategory), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO editCategoryDTO) {
        return new ResponseEntity<>(categoryService.updateCategory(editCategoryDTO), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCategory(Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
