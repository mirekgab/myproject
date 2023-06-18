package pl.mirekgab.myproject.category;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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

}
