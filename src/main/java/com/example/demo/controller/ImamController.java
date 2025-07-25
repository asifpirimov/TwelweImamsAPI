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

import com.example.demo.entity.Imam;
import com.example.demo.service.ImamService;

@RestController
@RequestMapping("/api/imams")
public class ImamController {
    @Autowired
    private ImamService imamService;


    @GetMapping
    public List<Imam> getAllImams() {
        return imamService.getAllImams();
    }

    @GetMapping("/{id}")
    public Imam getImamById(@PathVariable Long id) {
        return imamService.getImamById(id);
    }

    @PostMapping
    public Imam addImam(@RequestBody Imam imam) {
        return imamService.addImam(imam);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Imam> updateImam(@PathVariable Long id, @RequestBody Imam imam) {
        try {
            Imam updated = imamService.updateImam(id, imam);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteImam(@PathVariable Long id) {
        imamService.deleteImam(id);
        return ResponseEntity.ok().build();
    }
    

}
