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

import java.util.List;
import java.util.stream.Collectors;

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
    @DeleteMapping("/farms/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        farmService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Farm with ID " + id + " deleted successfully.");
    }
    @GetMapping("/farms/{id}")
    public ResponseEntity<FarmVm> findById(@PathVariable Long id){
        Farm farm = farmService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(farmMapper.toFarmVm(farm));
    }
    @GetMapping("/farms")
    public ResponseEntity<List<FarmVm>> findAll(){
        List<Farm> farms = farmService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(farms.stream().map(farmMapper::toFarmVm).collect(Collectors.toList()));
    }

}
