package com.example.citronix.service;

import com.example.citronix.entity.HarvestDetails;

import java.util.List;

public interface HarvestDetailsService {
    HarvestDetails save(HarvestDetails harvestDetails);
    void createAll(List<HarvestDetails> harvestDetails);
}
