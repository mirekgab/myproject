package pl.mirekgab.myproject.category;

import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface CategoryMapper {

    CategoryDTO mapToCategoryDTO(Category category);
}
