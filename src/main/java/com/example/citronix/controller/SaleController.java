package com.example.citronix.controller;

import com.example.citronix.dto.Sale.SaleCreateDTO;
import com.example.citronix.dto.Sale.SaleUpdateDTO;
import com.example.citronix.entity.Sale;
import com.example.citronix.mapper.SaleMapper;
import com.example.citronix.service.SaleService;
import com.example.citronix.vm.SaleVm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/sales/harvest")
    public ResponseEntity<List<SaleVm>> getSalesByHarvest(@RequestParam Long harvestId) {
        List<Sale> sales = saleService.findAllByHarvest(harvestId);
        List<SaleVm> response = sales.stream().map(saleMapper::toSaleVm).toList();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/sales")
    public ResponseEntity<List<SaleVm>> findAll(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Sale> sales = saleService.findAll(pageable);
        List<SaleVm> response = sales.stream().map(saleMapper::toSaleVm).toList();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/sales/{id}")
    public ResponseEntity<SaleVm> updateSale(
            @PathVariable Long id,
            @Valid @RequestBody SaleUpdateDTO saleUpdateDTO) {
        Sale updatedSale = saleService.update(saleUpdateDTO,id);
        SaleVm response = saleMapper.toSaleVm(updatedSale);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
