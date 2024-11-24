package com.example.citronix.service.implementation;

import com.example.citronix.dto.Sale.SaleCreateDTO;
import com.example.citronix.dto.Sale.SaleUpdateDTO;
import com.example.citronix.entity.Harvest;
import com.example.citronix.entity.Sale;
import com.example.citronix.exception.Sale.SaleNotFoundException;
import com.example.citronix.mapper.SaleMapper;
import com.example.citronix.repository.SaleRepository;
import com.example.citronix.service.HarvestService;
import com.example.citronix.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SaleServiceImpl implements SaleService {
    private  final SaleRepository saleRepository;
    private  final SaleMapper saleMapper;
    private  final HarvestService harvestService;
    @Override
    public Sale save(SaleCreateDTO saleCreateDTO) {
        Harvest harvest = harvestService.findById(saleCreateDTO.getHarvestId());
        validateQuantity(saleCreateDTO.getQuantity(), harvest);
        Sale sale = saleMapper.toSale(saleCreateDTO);
        sale.setRevenue(sale.getQuantity() * sale.getUnitPrice());
        sale.setHarvest(harvest);
        return saleRepository.save(sale);
    }

    @Override
    public Sale findById(Long id) {
        return saleRepository.findById(id)
                .orElseThrow(()->new SaleNotFoundException("sale with id : " + id + "not found")) ;
    }

    @Override
    public Sale update(SaleUpdateDTO saleUpdateDTO, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Sale sale = findById(id);
        saleRepository.delete(sale);
    }

    @Override
    public Page<Sale> findAll(Pageable pageable) {
        return saleRepository.findAll(pageable);
    }

    @Override
    public List<Sale> findAllByHarvest(Long id) {
        Harvest harvest = harvestService.findById(id);
        return saleRepository.findAllByHarvest(harvest);
    }


    public double totalQuantitySaled(List<Sale> sales) {
        return sales.stream()
                .mapToDouble(Sale::getQuantity)
                .sum();
    }

    private void validateQuantity(double requestedQuantity, Harvest harvest) {
        List<Sale> previousSales = saleRepository.findAllByHarvest(harvest);
        double quantitySaled = totalQuantitySaled(previousSales);
        double remaining = harvest.getTotalQuantity() - quantitySaled;

        if (remaining < requestedQuantity) {
            throw new IllegalArgumentException(
                    "There is no available quantity to sale. Remaining: " + remaining);
        }
    }
}
