package com.comiclibrary.controller;

import com.comiclibrary.dto.ComicDto;
import com.comiclibrary.dto.ComicRequest;
import com.comiclibrary.service.Top10Service;
import com.comiclibrary.service.ComicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comics")
public class ComicController {

    private final ComicService comicService;
    private final Top10Service top10Service;

    public ComicController(ComicService comicService, Top10Service top10Service) {
        this.comicService = comicService;
        this.top10Service = top10Service;
    }

    @GetMapping
    public List<ComicDto> list() { return comicService.list(); }

    @GetMapping("/{id}")
    public ComicDto get(@PathVariable Long id) { return comicService.get(id); }

    @GetMapping("/latest")
    public List<ComicDto> latest() { return comicService.latest(); }

    @GetMapping("/popular")
    public List<ComicDto> popular() { return comicService.popular(); }

    @GetMapping("/recommended")
    public List<ComicDto> recommended() { return comicService.recommended(); }

    @GetMapping("/top10")
    public List<ComicDto> top10(@RequestParam(defaultValue = "month") String period) { return top10Service.top10(period); }
}
