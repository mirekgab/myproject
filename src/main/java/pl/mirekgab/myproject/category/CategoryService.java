package pl.mirekgab.myproject.category;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.mirekgab.myproject.category.dto.CategoryDTO;
import pl.mirekgab.myproject.category.dto.CreateCategoryDTO;
import pl.mirekgab.myproject.category.exception.CategoryIsUsedException;
import pl.mirekgab.myproject.category.exception.CategoryNotFoundException;
import pl.mirekgab.myproject.product.ProductRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final ProductRepository productRepository;

    public List<CategoryDTO> getAllCategories(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Category> allCategories = categoryRepository.findAll(pageable);

        return allCategories.stream().map(categoryMapper::mapToCategoryDTO).toList();
    }

    public CategoryDTO createNewCategory(CreateCategoryDTO newCategory) {
        Category category = new Category.CategoryBuilder()
                .name(newCategory.name())
                .build();
        return categoryMapper.mapToCategoryDTO(categoryRepository.save(category));
    }

    public CategoryDTO updateCategory(CategoryDTO editCategoryDTO) {
        Category category = categoryRepository.findById(editCategoryDTO.id()).orElseThrow(
                () -> new CategoryNotFoundException(editCategoryDTO.id())
        );
        category.setName(editCategoryDTO.name());
        return categoryMapper.mapToCategoryDTO(categoryRepository.save(category));
    }

    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new CategoryNotFoundException(id);
        }
        if (productRepository.usedCategoryId(id)>0) {
            throw new CategoryIsUsedException(id);
        }
        categoryRepository.deleteById(id);
    }

    public CategoryDTO getCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()->new CategoryNotFoundException(categoryId));

        return categoryMapper.mapToCategoryDTO(category);
    }
}
