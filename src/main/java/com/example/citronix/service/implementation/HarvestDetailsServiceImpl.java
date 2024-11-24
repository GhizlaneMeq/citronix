package com.example.citronix.service.implementation;

import com.example.citronix.entity.HarvestDetails;
import com.example.citronix.repository.HarvestDetailsRepository;
import com.example.citronix.service.HarvestDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HarvestDetailsServiceImpl implements HarvestDetailsService {
    private  final HarvestDetailsRepository harvestDetailsRepository;

    @Override
    public HarvestDetails save(HarvestDetails harvestDetails) {
        return harvestDetailsRepository.save(harvestDetails);
    }
}
