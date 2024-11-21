package com.example.citronix.controller;

import com.example.citronix.dto.farm.FarmCreateDTO;
import com.example.citronix.dto.farm.FarmUpdateDTO;
import com.example.citronix.entity.Farm;
import com.example.citronix.mapper.FarmMapper;
import com.example.citronix.service.FarmService;
import com.example.citronix.vm.FarmVm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi")
@RequiredArgsConstructor
public class FarmController {
    private final FarmService farmService;
    private final FarmMapper farmMapper;

    @PostMapping("/farms")
    public ResponseEntity<FarmVm> create(@Valid @RequestBody FarmCreateDTO farmCreateDTO){
        FarmVm createdFarm = farmMapper.toFarmVm(farmService.save(farmCreateDTO));
        return ResponseEntity.ok(createdFarm);
    }

    @PutMapping("/farms/{id}")
    public ResponseEntity<FarmVm> update(@PathVariable Long id, @Valid @RequestBody FarmUpdateDTO farmUpdateDTO){
        Farm farm = farmService.update(farmUpdateDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body(farmMapper.toFarmVm(farm));
    }
}
