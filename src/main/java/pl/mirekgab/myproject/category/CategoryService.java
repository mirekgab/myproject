package pl.mirekgab.myproject.category;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.mirekgab.myproject.errorhandler.AppRuntimeException;
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
                () -> new AppRuntimeException(String.format("category with id %d not exist", editCategoryDTO.id()))
        );
        category.setName(editCategoryDTO.name());
        return categoryMapper.mapToCategoryDTO(categoryRepository.save(category));
    }

    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new AppRuntimeException(String.format("category with id %d not exists", id));
        }
        if (productRepository.usedCategoryId(id)>0) {
            throw new AppRuntimeException(String.format("category with id %d is used in products", id));
        }
        categoryRepository.deleteById(id);
    }
}
