package com.example.citronix.vm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HarvestVm {
    private Long id;
    private LocalDateTime harvestDate;
    private double totalQuantity;
    private List<HarvestDetailsVm> harvestDetails;
}
