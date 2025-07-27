package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ImamDTO;

public interface ImamService {
    public List<ImamDTO> getAllImams();
    public ImamDTO getImamById(Long id);
    public ImamDTO addImam(ImamDTO imam);
    public ImamDTO updateImam(Long id, ImamDTO updatedImam);
    public void deleteImam(Long id);
}
