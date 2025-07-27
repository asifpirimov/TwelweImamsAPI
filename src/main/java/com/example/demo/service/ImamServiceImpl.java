package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ImamDTO;
import com.example.demo.entity.Imam;
import com.example.demo.exception.ImamNotFoundException;
import com.example.demo.mapper.ImamMapper;
import com.example.demo.repository.ImamRepository;

@Service
public class ImamServiceImpl implements ImamService{
    private final ImamRepository imamRepository;
    private final ImamMapper imamMapper;

    public ImamServiceImpl(ImamRepository imamRepository, ImamMapper imamMapper) {
        this.imamRepository = imamRepository;
        this.imamMapper = imamMapper;
    }

    @Override
    public List<ImamDTO> getAllImams() {
        return imamRepository.findAll().stream()
                                .map(imamMapper::toDTO)
                                .collect(Collectors.toList());
    }

    @Override
    public ImamDTO getImamById(Long id) {
        Imam imam = imamRepository.findById(id)
            .orElseThrow(() -> new ImamNotFoundException(id));
        return imamMapper.toDTO(imam);
    }

    @Override
    public ImamDTO addImam(ImamDTO imam) {
        Imam entity = imamMapper.toEntity(imam);
        Imam saved = imamRepository.save(entity);
        return imamMapper.toDTO(saved);
    }

    @Override
    public ImamDTO updateImam(Long id, ImamDTO updatedImam) {
        Imam found = imamRepository.findById(id)
            .orElseThrow(() -> new ImamNotFoundException(id));
        found.setName(updatedImam.getName());
        found.setKunya(updatedImam.getKunya());
        found.setBirthDate(updatedImam.getBirthDate());
        found.setBirthPlace(updatedImam.getBirthPlace());
        found.setDeathDate(updatedImam.getDeathDate());
        found.setDeathPlace(updatedImam.getDeathPlace());
        found.setFatherName(updatedImam.getFatherName());
        found.setMotherName(updatedImam.getMotherName());
        found.setBiography(updatedImam.getBiography());
        found.setOrderInImamate(updatedImam.getOrderInImamate());
        found.setShrineLocation(updatedImam.getShrineLocation());
        found.setFamousSayings(updatedImam.getFamousSayings());

        Imam newImam = imamRepository.save(found);
        return imamMapper.toDTO(newImam);

    }

    @Override
    public void deleteImam(Long id) {
        if (!imamRepository.existsById(id)) {
            throw new ImamNotFoundException(id);
        }
        imamRepository.deleteById(id);
    }

}
