package com.example.citronix.mapper;

import com.example.citronix.dto.farm.FarmCreateDTO;
import com.example.citronix.entity.Farm;
import com.example.citronix.vm.FarmVm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FarmMapper {

    @Mapping(source = "createdAt", target = "createdAt")
    Farm toFarm(FarmCreateDTO farmCreateDTO);

    FarmVm toFarmVm(Farm farm);

}
