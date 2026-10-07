package com.comiclibrary.service;

import com.comiclibrary.dto.ChapterDetailDto;
import com.comiclibrary.dto.ChapterDto;
import com.comiclibrary.dto.ChapterRequest;
import com.comiclibrary.entity.Chapter;
import com.comiclibrary.entity.Comic;
import com.comiclibrary.exception.ResourceNotFoundException;
import com.comiclibrary.repository.ChapterRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChapterService {

    private final ChapterRepository chapterRepository;
    private final ComicService comicService;

    public ChapterService(ChapterRepository chapterRepository, ComicService comicService) {
        this.chapterRepository = chapterRepository;
        this.comicService = comicService;
    }

    @Transactional(readOnly = true)
    public List<ChapterDto> listByComic(Long comicId) {
        comicService.find(comicId);
        return chapterRepository.findByComicIdOrderByChapterNumberDesc(comicId).stream().map(ChapterDto::from).toList();
    }

    @Transactional(readOnly = true)
    public ChapterDetailDto get(Long id) {
        return ChapterDetailDto.from(find(id));
    }

    public Chapter find(Long id) {
        return chapterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Chapter not found: " + id));
    }

    @Transactional
    public ChapterDto create(Long comicId, ChapterRequest request) {
        Comic comic = comicService.find(comicId);
        Chapter chapter = Chapter.builder()
            .comic(comic)
            .chapterNumber(request.chapterNumber())
            .title(request.title())
            .publishedAt(request.publishedAt())
            .build();
        return ChapterDto.from(chapterRepository.save(chapter));
    }

    @Transactional
    public ChapterDto update(Long id, ChapterRequest request) {
        Chapter chapter = find(id);
        chapter.setChapterNumber(request.chapterNumber());
        chapter.setTitle(request.title());
        chapter.setPublishedAt(request.publishedAt());
        return ChapterDto.from(chapterRepository.save(chapter));
    }

    public void delete(Long id) {
        chapterRepository.delete(find(id));
    }
}
