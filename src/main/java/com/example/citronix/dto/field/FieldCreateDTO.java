package com.example.citronix.dto.field;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FieldCreateDTO {
    @NotBlank(message = "Name is required")
    private String name;

    @Min(value = 1000, message = "Area must be At least 1000m²")
    @NotNull (message = "Area cannot be null")
    private double area;

    @NotNull(message = "FarmId cannot be null")
    private Long farmId;
}
