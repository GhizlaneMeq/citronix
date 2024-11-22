package com.example.citronix.service.implementation;

import com.example.citronix.dto.farm.FarmCreateDTO;
import com.example.citronix.dto.farm.FarmUpdateDTO;
import com.example.citronix.entity.Farm;
import com.example.citronix.exception.Farm.FarmAlreadyExistedException;
import com.example.citronix.exception.Farm.FarmNotFoundException;
import com.example.citronix.mapper.FarmMapper;
import com.example.citronix.repository.FarmRepository;
import com.example.citronix.service.FarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;
    private final FarmMapper farmMapper;

    @Override
    public Farm save(FarmCreateDTO farmCreateDTO) {
        if (farmRepository.existsByName(farmCreateDTO.getName())) {
            throw new FarmAlreadyExistedException("Farm with the name '" + farmCreateDTO.getName() + "' already exists.");
        }


        return farmRepository.save(farmMapper.toFarm(farmCreateDTO));
    }

    @Override
    public Farm update(FarmUpdateDTO farmUpdateDTO, Long id) {
        Farm existingFarm = farmRepository.findById(id)
                .orElseThrow(() ->new FarmNotFoundException("Fame with id " + id + " not found"));
        Farm newFarm = farmMapper.partialUpdate(farmUpdateDTO, existingFarm);
        return farmRepository.save(newFarm);
    }

    @Override
    public void delete(Long id) {
        Farm farm =  farmRepository.findById(id)
                .orElseThrow(() -> new FarmNotFoundException("Fame with id " + id + " not found"));
        farmRepository.delete(farm);;
    }

    @Override
    public Farm findById(Long id) {
        return farmRepository.findById(id)
                .orElseThrow(() -> new FarmNotFoundException("Fame with id " + id + " not found"));
    }

    @Override
    public List<Farm> findAll() {
        return farmRepository.findAll();
    }

}
