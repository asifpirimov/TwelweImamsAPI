package com.example.demo.mapper;

import org.springframework.context.annotation.Configuration;

import com.example.demo.dto.ImamDTO;
import com.example.demo.entity.Imam;

@Configuration
public class ImamMapper {
    public ImamDTO toDTO(Imam imam) {
        return ImamDTO.builder()
            .name(imam.getName())
            .kunya(imam.getKunya())
            .birthDate(imam.getBirthDate())
            .birthPlace(imam.getBirthPlace())
            .deathDate(imam.getDeathDate())
            .deathPlace(imam.getDeathPlace())
            .fatherName(imam.getFatherName())
            .motherName(imam.getMotherName())
            .biography(imam.getBiography())
            .orderInImamate(imam.getOrderInImamate())
            .shrineLocation(imam.getShrineLocation())
            .famousSayings(imam.getFamousSayings())
            .build();
    }

    public Imam toEntity(ImamDTO imamDTO) {
        return Imam.builder()
            .name(imamDTO.getName())
            .kunya(imamDTO.getKunya())
            .birthDate(imamDTO.getBirthDate())
            .birthPlace(imamDTO.getBirthPlace())
            .deathDate(imamDTO.getDeathDate())
            .deathPlace(imamDTO.getDeathPlace())
            .fatherName(imamDTO.getFatherName())
            .motherName(imamDTO.getMotherName())
            .biography(imamDTO.getBiography())
            .orderInImamate(imamDTO.getOrderInImamate())
            .shrineLocation(imamDTO.getShrineLocation())
            .famousSayings(imamDTO.getFamousSayings())
            .build();
    }
}
