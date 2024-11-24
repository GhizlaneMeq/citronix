package com.example.citronix.helpers;

import com.example.citronix.entity.Farm;
import com.example.citronix.entity.Field;
import com.example.citronix.exception.Farm.FarmNotFoundException;
import com.example.citronix.repository.FarmRepository;
import com.example.citronix.repository.FieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FieldValidationHelper {
    private final FarmRepository FarmRepository;
    private final FieldRepository FieldRepository;
    private final FarmRepository farmRepository;

    public void validateFieldArea(Long farmId, double fieldArea){
        Farm farm = farmRepository.findById(farmId).orElseThrow(() -> new FarmNotFoundException("farm with id " + farmId + "does not exist"));

        double totalFieldArea = FieldRepository.findAllByFarm(farm).stream()
           .mapToDouble(Field::getArea)
           .sum();

        // Validate if the field area exceeds 50% of the total farm area
        if(fieldArea > 0.5 * farm.getArea()){
            throw new IllegalArgumentException("The field cannot exceed 50% of the total farm area.");
        }

        // Validate if the field area does not exceed the total area of fields in the farm
        if(totalFieldArea + fieldArea > farm.getArea()){
            throw new IllegalArgumentException("The total area of fields cannot exceed the total farm area.");
        }
    }
    public void validateFieldCount(Long farmId){
        Farm farm = farmRepository.findById(farmId).orElseThrow(() -> new FarmNotFoundException("farm with id " + farmId + " does not exist"));

        int totalFieldCount = FieldRepository.findAllByFarm(farm).size();

        if(totalFieldCount > 100){
            throw new IllegalArgumentException("The number of fields cannot exceed 100.");
        }
    }
}
