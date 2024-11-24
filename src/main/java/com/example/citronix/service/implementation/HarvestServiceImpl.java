package com.example.citronix.service.implementation;

import com.example.citronix.dto.harvest.HarvestCreateDTO;
import com.example.citronix.dto.harvest.HarvestUpdateDTO;
import com.example.citronix.entity.Field;
import com.example.citronix.entity.Harvest;
import com.example.citronix.entity.enums.Season;
import com.example.citronix.mapper.HarvestMapper;
import com.example.citronix.repository.HarvestRepository;
import com.example.citronix.service.FieldService;
import com.example.citronix.service.HarvestDetailsService;
import com.example.citronix.service.HarvestService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class HarvestServiceImpl implements HarvestService {
    private  final HarvestDetailsService harvestDetailsService;
    private HarvestRepository harvestRepository;
    private HarvestMapper harvestMapper;
    private final FieldService fieldService;

    @Transactional
    @Override
    public Harvest save(HarvestCreateDTO harvestCreateDTO) {
        Field field = fieldService.findById(harvestCreateDTO.getFieldId()) ;
        Season season= determineSeason(harvestCreateDTO.getHarvestDate());
        int year = harvestCreateDTO.getHarvestDate().getYear();
        if(harvestRepository.existsByFieldAndSeasonAndHarvestDateYear(field, season, year)){
            throw new IllegalArgumentException("A harvest already exists for this field in the " + season + " season of " + year);
        }
        Harvest harvest = harvestMapper.toHarvest(harvestCreateDTO);

        return null;
    }

    @Override
    public Harvest findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Harvest update(Long id, HarvestUpdateDTO harvestUpdateDTO) {
        return null;
    }


    private Season determineSeason(LocalDateTime harvestDate) {
        if (harvestDate == null) {
            throw new IllegalArgumentException("Harvest date cannot be null");
        }

        int month = harvestDate.getMonthValue();
        int day = harvestDate.getDayOfMonth();

        if ((month == 12 && day >= 21) || month == 1 || month == 2 || (month == 3 && day <= 20)) {
            return Season.WINTER;
        }
        else if ((month == 3 && day >= 21) || month == 4 || month == 5 || (month == 6 && day <= 20)) {
            return Season.SPRING;
        }
        else if ((month == 6 && day >= 21) || month == 7 || month == 8 || (month == 9 && day <= 22)) {
            return Season.SUMMER;
        }
        else if ((month == 9 && day >= 23) || month == 10 || month == 11 || (month == 12 && day <= 20)) {
            return Season.FALL;
        }

        throw new IllegalStateException("Invalid date provided: " + harvestDate); // Safety fallback
    }

}