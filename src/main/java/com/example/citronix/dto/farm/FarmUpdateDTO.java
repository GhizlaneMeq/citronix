package com.example.citronix.dto.farm;


import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FarmUpdateDTO {
    private String name;
    private String location;
    private double area;
}
