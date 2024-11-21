package com.example.citronix.entity;

import com.example.citronix.entity.enums.TreeStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Tree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime plantationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TreeStatus status;

    @ManyToOne
    @JoinColumn(name = "field_id", nullable = false)
    private Field field;

    @OneToMany(mappedBy = "tree")
    private List<HarvestDetails> harvestDetails;
}
