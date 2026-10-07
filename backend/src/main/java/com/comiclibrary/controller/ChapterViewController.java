package com.comiclibrary.controller;

import com.comiclibrary.service.ViewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChapterViewController {

    private final ViewService viewService;

    public ChapterViewController(ViewService viewService) {
        this.viewService = viewService;
    }

    @PostMapping("/api/v1/chapters/{id}/view")
    public ResponseEntity<Void> recordView(@PathVariable Long id) {
        viewService.recordChapterView(id);
        return ResponseEntity.noContent().build();
    }
}
