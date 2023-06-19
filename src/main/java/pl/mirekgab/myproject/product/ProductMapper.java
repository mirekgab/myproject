package pl.mirekgab.myproject.product;

import org.mapstruct.Mapper;
import pl.mirekgab.myproject.product.dto.ProductDTO;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO mapEntityToDTO(Product product);
}
