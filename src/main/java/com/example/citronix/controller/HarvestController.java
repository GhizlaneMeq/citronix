package com.example.citronix.controller;

import com.example.citronix.dto.harvest.HarvestCreateDTO;
import com.example.citronix.dto.harvest.HarvestUpdateDTO;
import com.example.citronix.entity.Harvest;
import com.example.citronix.mapper.HarvestMapper;
import com.example.citronix.service.HarvestService;
import com.example.citronix.vm.HarvestVm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @DeleteMapping("/harvest/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        harvestService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/harvest/{id}")
    public ResponseEntity<HarvestVm> update(
            @PathVariable Long id,
            @Valid @RequestBody HarvestUpdateDTO harvestUpdateDTO
    ) {
        Harvest updatedHarvest = harvestService.update(id, harvestUpdateDTO);
        HarvestVm response = harvestMapper.toResponse(updatedHarvest);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/harvest/{id}")
    public ResponseEntity<HarvestVm> findById(@PathVariable Long id) {
        Harvest harvest = harvestService.findById(id);
        HarvestVm response = harvestMapper.toResponse(harvest);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
