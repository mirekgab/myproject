package pl.mirekgab.myproject.category;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return Arrays.asList(
                new CategoryDTO(1L, "category1"),
                new CategoryDTO(2L, "category2"));
    }
}
