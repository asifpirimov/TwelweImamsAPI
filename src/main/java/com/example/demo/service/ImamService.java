package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Imam;
import com.example.demo.repository.ImamRepository;

@Service
public class ImamService {
    private final ImamRepository imamRepository;

    public ImamService(ImamRepository imamRepository) {
        this.imamRepository = imamRepository;
    }

    public List<Imam> getAllImams() {
        return imamRepository.findAll();
    }

    public Imam getImamById(Long id) {
        return imamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Imam not found with id: " + id));
    }

    public Imam addImam(Imam imam) {
        return imamRepository.save(imam);
    }

    public Imam updateImam(Long id, Imam updatedImam) {
        return imamRepository.findById(id).map(imam -> {
            updatedImam.setId(id);
            return imamRepository.save(updatedImam);
        }).orElseThrow(() -> new RuntimeException("Imam not found"));
    }

    public void deleteImam(Long id) {
        if (!imamRepository.existsById(id)) {
            throw new RuntimeException("Imam not found with id: " + id);
        }
        imamRepository.deleteById(id);
    }

}
