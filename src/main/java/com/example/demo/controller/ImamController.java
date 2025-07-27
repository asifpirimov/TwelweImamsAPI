package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ImamDTO;
import com.example.demo.service.ImamServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/imams")
public class ImamController {
    @Autowired
    private ImamServiceImpl imamService;

    @Operation(summary="Getting info about all Imams", description="Retrieve a list of all Imams from table")
    @ApiResponses(value={
        @ApiResponse(responseCode="200", description="Info about Imams retrieved successfully"),
        @ApiResponse(responseCode="404", description="No info about Imams found")
        }
    )
    @GetMapping
    public List<ImamDTO> getAllImams() {
        return imamService.getAllImams();
    }

    @Operation(summary="Getting info about Imam by ID", description="Retrieve info about Imam by ID")
    @ApiResponses(value={
        @ApiResponse(responseCode="200", description="Info about Imam found"),
        @ApiResponse(responseCode="404", description="Info about Imam not found")
    })
    @GetMapping("/{id}")
    public ImamDTO getImamById(@PathVariable Long id) {
        return imamService.getImamById(id);
    }

    @Operation(summary="Add new Imam", description="Add info about an Imam to table")
    @ApiResponses(value={
        @ApiResponse(responseCode="201", description="Info about Imam added successfully"),
        @ApiResponse(responseCode="400", description="Invalid Imam data")
    })
    @PostMapping
    public ImamDTO addImam(@RequestBody ImamDTO imamDTO) {
        return imamService.addImam(imamDTO);
    }

    @Operation(summary="Update info of Imam", description="Update the existing info of Imam")
    @ApiResponses(value={
        @ApiResponse(responseCode="200", description="Info updated successfully"),
        @ApiResponse(responseCode="400", description="Invalid info"),
        @ApiResponse(responseCode="404", description="Info not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ImamDTO> updateImam(@PathVariable Long id, @RequestBody ImamDTO imamDTO) {
        try {
            ImamDTO updated = imamService.updateImam(id, imamDTO);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Delete info about Imam", description = "Delete info about Imam from the library by ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Info about Imam deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Info about Imam not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteImam(@PathVariable Long id) {
        imamService.deleteImam(id);
        return ResponseEntity.ok().build();
    }
    

}
