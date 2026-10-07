package com.comiclibrary.controller;

import com.comiclibrary.dto.ChapterDto;
import com.comiclibrary.dto.ChapterRequest;
import com.comiclibrary.service.ChapterService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminChapterController {

    private final ChapterService chapterService;

    public AdminChapterController(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @PostMapping("/api/v1/admin/comics/{id}/chapters")
    public ResponseEntity<ChapterDto> create(@PathVariable Long id, @Valid @RequestBody ChapterRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(chapterService.create(id, request));
    }

    @PutMapping("/api/v1/admin/chapters/{id}")
    public ChapterDto update(@PathVariable Long id, @Valid @RequestBody ChapterRequest request) {
        return chapterService.update(id, request);
    }

    @DeleteMapping("/api/v1/admin/chapters/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        chapterService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
