package pl.mirekgab.myproject.product;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO mapEntityToDTO(Product product);
}
