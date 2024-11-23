package com.example.citronix.dto.Tree;

import com.example.citronix.helpers.Tree.ValidPlantingPeriod;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TreeUpdateDTO {

    @ValidPlantingPeriod
    @PastOrPresent(message = "must be in past or present")
    private LocalDateTime plantationDate;
}
