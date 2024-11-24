package com.example.citronix.dto.Sale;

import jakarta.validation.constraints.Positive;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleUpdateDTO{
    @Positive(message = "unitPrice needs to be positive")
    private Double unitPrice;

    @Positive(message = "quantity needs to be positive")
    private Double quantity;

    private String client;
}
