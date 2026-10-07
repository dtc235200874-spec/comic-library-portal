package com.comiclibrary.controller;

import com.comiclibrary.dto.ChapterDetailDto;
import com.comiclibrary.dto.ChapterDto;
import com.comiclibrary.service.ChapterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChapterQueryController {

    private final ChapterService chapterService;

    public ChapterQueryController(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @GetMapping("/api/v1/comics/{id}/chapters")
    public List<ChapterDto> listByComic(@PathVariable Long id) {
        return chapterService.listByComic(id);
    }

    @GetMapping("/api/v1/chapters/{id}")
    public ChapterDetailDto get(@PathVariable Long id) {
        return chapterService.get(id);
    }
}
