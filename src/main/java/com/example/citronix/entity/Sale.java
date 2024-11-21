package com.example.citronix.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    private Double unitPrice;
    private Double quantity;
    private String client;
    private double revenue;

    @ManyToOne
    @JoinColumn(name="harvest_id", nullable = false )
    private Harvest harvest;
}
