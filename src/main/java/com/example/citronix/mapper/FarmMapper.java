package com.example.citronix.mapper;

import com.example.citronix.dto.farm.FarmCreateDTO;
import com.example.citronix.dto.farm.FarmUpdateDTO;
import com.example.citronix.entity.Farm;
import com.example.citronix.vm.FarmVm;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface FarmMapper {

    @Mapping(source = "createdAt", target = "createdAt")
    Farm toFarm(FarmCreateDTO farmCreateDTO);
    Farm toEntity(FarmUpdateDTO farmUpdateDTO);
    FarmUpdateDTO toDto(Farm farm);
    FarmVm toFarmVm(Farm farm);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Farm partialUpdate(FarmUpdateDTO farmUpdateDTO, @MappingTarget Farm farm);

}
