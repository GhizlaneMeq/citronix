package com.example.citronix.service;

import com.example.citronix.dto.field.FieldCreateDTO;
import com.example.citronix.dto.field.FieldUpdateDTO;
import com.example.citronix.entity.Field;

public interface FieldService {
    Field save(FieldCreateDTO fieldCreateDTO);
    Field findById(Long id);
    Field update(FieldUpdateDTO fieldUpdateDTO, Long id);
    void delete(Long id);

}
