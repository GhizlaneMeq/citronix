package com.example.citronix.service.implementation;

import com.example.citronix.dto.field.FieldCreateDTO;
import com.example.citronix.entity.Farm;
import com.example.citronix.entity.Field;
import com.example.citronix.mapper.FieldMapper;
import com.example.citronix.repository.FieldRepository;
import com.example.citronix.service.FarmService;
import com.example.citronix.service.FieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FieldServiceImpl implements FieldService {
    private final FieldRepository fieldRepository;
    private final FieldMapper fieldMapper;
    private final FarmService farmService;

    @Override
    public Field save(FieldCreateDTO fieldCreateDTO) {
        Farm farm = farmService.findById
        return null;
    }
}
