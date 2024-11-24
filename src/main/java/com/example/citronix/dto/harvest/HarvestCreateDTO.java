package com.example.citronix.dto.harvest;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HarvestCreateDTO {
    @NotNull(message = "harvestDate is required")
    private LocalDateTime harvestDate;

    @NotNull(message = "fieldId is required")
    private Long fieldId;
}