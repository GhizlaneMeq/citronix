package com.example.citronix.mapper;

import com.example.citronix.dto.field.FieldCreateDTO;
import com.example.citronix.entity.Field;
import com.example.citronix.vm.FieldVm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FieldMapper {
    @Mapping(target = "farm.id", source = "farmId")
    Field toField(FieldCreateDTO fieldCreateDTO);
    FieldVm toFieldVm(Field field);

}
