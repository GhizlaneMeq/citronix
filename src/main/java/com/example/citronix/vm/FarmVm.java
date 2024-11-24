package com.example.citronix.vm;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class FarmVm {
    private Long id;
    private String name;
    private String location;
    private double totalarea;
    private LocalDateTime createdAt;

}
