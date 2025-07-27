package com.example.demo.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImamDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String kunya;

    @NotNull
    private LocalDate birthDate;

    @NotBlank
    private String birthPlace;

    private LocalDate deathDate;

    private String deathPlace;

    @NotBlank
    private String fatherName;

    @NotBlank
    private String motherName;

    private String biography;

    @NotNull
    private Integer orderInImamate;

    private String shrineLocation;

    private List<@NotBlank String> famousSayings;
}
