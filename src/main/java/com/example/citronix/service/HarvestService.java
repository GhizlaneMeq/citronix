package com.example.citronix.service;

import com.example.citronix.dto.harvest.HarvestCreateDTO;
import com.example.citronix.dto.harvest.HarvestUpdateDTO;
import com.example.citronix.entity.Harvest;

public interface HarvestService {
    Harvest save(HarvestCreateDTO harvestCreateDTO);
    Harvest findById(Long id);
    void delete(Long id);
    Harvest update(Long id, HarvestUpdateDTO harvestUpdateDTO);
}
