package com.example.citronix.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private Double area;

    @Column(name = "created_at", nullable = false,updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "farm")
    private List<Field> fields;
}
