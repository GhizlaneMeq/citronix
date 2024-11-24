package com.example.citronix.vm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HarvestDetailsVm {
    private Long id;
    private double quantity;
    private Long treeId;
    private LocalDateTime treePlantationDate;
}
