package com.example.citronix.vm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.Period;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TreeVm {
    private Long id;
    private Long age;
    private FieldVm field;
    private LocalDateTime plantationDate;

    public void setPlantationDate(LocalDateTime plantationDate) {
        this.plantationDate = plantationDate;
        if (plantationDate != null) {
            LocalDateTime currentDate = LocalDateTime.now();
            Period period = Period.between(plantationDate.toLocalDate(), currentDate.toLocalDate());
            this.age = (long) period.getYears();
        }
    }
}
