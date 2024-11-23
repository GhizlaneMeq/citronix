package com.example.citronix.service.implementation;

import com.example.citronix.dto.field.FieldCreateDTO;
import com.example.citronix.dto.field.FieldUpdateDTO;
import com.example.citronix.entity.Farm;
import com.example.citronix.entity.Field;
import com.example.citronix.exception.Field.FieldNotFoundException;
import com.example.citronix.helpers.FieldValidationHelper;
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
    private  final FieldValidationHelper fieldValidationHelper;

    @Override
    public Field save(FieldCreateDTO fieldCreateDTO) {
        Farm farm = farmService.findById(fieldCreateDTO.getFarmId());

        fieldValidationHelper.validateFieldArea(farm.getId(), fieldCreateDTO.getArea());
        fieldValidationHelper.validateFieldCount(farm.getId());

        Field field = fieldMapper.toField(fieldCreateDTO);

        field.setFarm(farm);

        return fieldRepository.save(field);
    }

    @Override
    public Field findById(Long id) {
        return fieldRepository.findById(id)
                .orElseThrow(() -> new FieldNotFoundException("Field with id : " + id + " not found"));
    }

    @Override
    public Field update(FieldUpdateDTO fieldUpdateDTO, Long id) {
        Field existingField = fieldRepository.findById(id)
                .orElseThrow(() -> new FieldNotFoundException("Field not found with ID: " + id));

        Farm farm = farmService.findById(existingField.getFarm().getId());
        fieldValidationHelper.validateFieldArea(farm.getId(), fieldUpdateDTO.getArea());
        fieldValidationHelper.validateFieldCount(farm.getId());

        existingField.setName(fieldUpdateDTO.getName());
        existingField.setArea(fieldUpdateDTO.getArea());
        existingField.setFarm(farm);

        return fieldRepository.save(existingField);
    }

    @Override
    public void delete(Long id) {
        Field field = findById(id);
        fieldRepository.delete(field);

    }
}
