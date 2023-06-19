package pl.mirekgab.myproject.category;

import org.mapstruct.Mapper;
import pl.mirekgab.myproject.category.dto.CategoryDTO;

@Mapper(componentModel="spring")
public interface CategoryMapper {

    CategoryDTO mapToCategoryDTO(Category category);
}
