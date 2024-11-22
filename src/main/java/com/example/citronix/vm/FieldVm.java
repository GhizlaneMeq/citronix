package com.example.citronix.vm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FieldVm {
    private String name;
    private double area;
    private FarmVm farmVm;
}
