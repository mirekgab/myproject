package pl.mirekgab.myproject.stock;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StockMapper {

    StockDTO mapEntityToDTO(Stock stock);
}
