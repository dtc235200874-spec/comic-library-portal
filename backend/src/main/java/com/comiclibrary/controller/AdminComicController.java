package com.comiclibrary.controller;

import com.comiclibrary.dto.ComicDto;
import com.comiclibrary.dto.ComicRequest;
import com.comiclibrary.service.ComicService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/comics")
public class AdminComicController {

    private final ComicService comicService;

    public AdminComicController(ComicService comicService) {
        this.comicService = comicService;
    }

    @PostMapping
    public ResponseEntity<ComicDto> create(@Valid @RequestBody ComicRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(comicService.create(request));
    }

    @PutMapping("/{id}")
    public ComicDto update(@PathVariable Long id, @Valid @RequestBody ComicRequest request) {
        return comicService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        comicService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
