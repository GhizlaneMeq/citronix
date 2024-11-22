package com.example.citronix.service;

import com.example.citronix.dto.field.FieldCreateDTO;
import com.example.citronix.entity.Field;

public interface FieldService {
    Field save(FieldCreateDTO fieldCreateDTO);

}
