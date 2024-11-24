package com.example.citronix.mapper;

import com.example.citronix.dto.Sale.SaleCreateDTO;
import com.example.citronix.dto.Sale.SaleUpdateDTO;
import com.example.citronix.entity.Sale;
import com.example.citronix.vm.SaleVm;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface SaleMapper {
    @Mapping(target = "harvest.id", source = "harvestId")
    Sale toSale(SaleCreateDTO saleCreateDto);

    @Mapping(source = "harvest.id", target = "harvestId")
    @Mapping(source = "harvest.totalQuantity", target = "harvestTotalQuantity")
    @Mapping(source = "harvest.harvestDate", target = "harvestDate")
    @Mapping(source = "harvest.season", target = "harvestSeason")
    SaleVm toSaleVm(Sale sale);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Sale partialUpdate(SaleUpdateDTO saleUpdateDto, @MappingTarget Sale sale);
}
