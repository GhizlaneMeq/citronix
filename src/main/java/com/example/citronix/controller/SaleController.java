package com.example.citronix.controller;

import com.example.citronix.dto.Sale.SaleCreateDTO;
import com.example.citronix.entity.Sale;
import com.example.citronix.mapper.SaleMapper;
import com.example.citronix.service.SaleService;
import com.example.citronix.vm.SaleVm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi")
@RequiredArgsConstructor
public class SaleController {
    private final SaleService saleService;
    private final SaleMapper saleMapper;


    @PostMapping("/sales")
    public ResponseEntity<SaleVm> create(@Valid @RequestBody SaleCreateDTO saleCreateDTO) {
        Sale sale = saleService.save(saleCreateDTO);
        SaleVm response = saleMapper.toSaleVm(sale);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/sales/{id}")
    public ResponseEntity<SaleVm> findById(@PathVariable Long id) {
        Sale sale = saleService.findById(id);
        SaleVm response = saleMapper.toSaleVm(sale);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
