package com.example.citronix.controller;

import com.example.citronix.dto.harvest.HarvestCreateDTO;
import com.example.citronix.entity.Harvest;
import com.example.citronix.mapper.HarvestMapper;
import com.example.citronix.service.HarvestService;
import com.example.citronix.vm.HarvestVm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vi")
@RequiredArgsConstructor
public class HarvestController {
    private final HarvestService harvestService;
    private final HarvestMapper harvestMapper;

    @PostMapping("/harvest")
    public ResponseEntity<HarvestVm> create(@Valid @RequestBody HarvestCreateDTO harvestCreateDTO) {
        Harvest harvest = harvestService.save(harvestCreateDTO);
        HarvestVm response = harvestMapper.toResponse(harvest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
