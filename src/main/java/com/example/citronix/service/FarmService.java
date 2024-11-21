package com.example.citronix.service;

import com.example.citronix.dto.farm.FarmCreateDTO;
import com.example.citronix.entity.Farm;

public interface FarmService {

    Farm save(FarmCreateDTO farmCreateDTO);
}
