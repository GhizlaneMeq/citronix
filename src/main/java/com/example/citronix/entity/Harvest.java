package com.example.citronix.entity;

import com.example.citronix.entity.enums.Season;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Harvest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Season season;

    private Double amount;
    private LocalDateTime harvestDate;
    private Double totalQuantity;

    @OneToMany(mappedBy = "harvest")
    private List<HarvestDetails> harvestDetails;

    @OneToMany(mappedBy = "harvest")
    private List<Sale> sales;

}
