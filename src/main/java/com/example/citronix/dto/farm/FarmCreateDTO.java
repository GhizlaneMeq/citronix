package com.example.citronix.dto.farm;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FarmCreateDTO {

    @NotBlank(message = "Farm name is required.")
    @Size(max = 100, message = "Farm name should not exceed 100 characters.")
    private String name;

    @NotBlank(message = "Location is required.")
    @Size(max = 200, message = "Location should not exceed 200 characters.")
    private String location;

    @NotNull(message = "area is required.")
    @Positive(message = "area must be greater than 0.")
    private double area;

    private LocalDateTime createdAt;
}
