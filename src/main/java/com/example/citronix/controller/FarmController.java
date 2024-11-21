package com.example.citronix.controller;

import com.example.citronix.dto.farm.FarmCreateDTO;
import com.example.citronix.mapper.FarmMapper;
import com.example.citronix.service.FarmService;
import com.example.citronix.vm.FarmVm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vi")
@RequiredArgsConstructor
public class FarmController {
    private final FarmService farmService;
    private final FarmMapper farmMapper;

    @PostMapping("/farms")
    public ResponseEntity<FarmVm> createFarm(@Valid @RequestBody FarmCreateDTO farmCreateDTO){
        FarmVm createdFarm = farmMapper.toFarmVm(farmService.save(farmCreateDTO));
        return ResponseEntity.ok(createdFarm);
    }
}
