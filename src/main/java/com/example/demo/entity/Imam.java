package com.example.demo.entity;

import java.time.LocalDate;
import java.util.List;
import jakarta.validation.constraints.NotNull;  
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "imams")
public class Imam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 3, max = 255)
    private String name;
    private String kunya;
    private LocalDate birthDate;
    private String birthPlace;
    
    private LocalDate deathDate;
    private String deathPlace;

    private String fatherName;
    private String motherName;

    @Column(length = 5000, nullable = true)
    private String biography;

    @Column(updatable = false)
    private int orderInImamate;
    private String shrineLocation;

    @ElementCollection
    private List<String> famousSayings;



}
