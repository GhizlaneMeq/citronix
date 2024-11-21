package com.example.citronix.service;

import com.example.citronix.dto.farm.FarmCreateDTO;
import com.example.citronix.dto.farm.FarmUpdateDTO;
import com.example.citronix.entity.Farm;

import java.util.List;

public interface FarmService {

    Farm save(FarmCreateDTO farmCreateDTO);
    Farm update(FarmUpdateDTO farmUpdateDTO, Long id);
    void delete(Long id);
    Farm findById(Long id);
    List<Farm> findAll();

}
