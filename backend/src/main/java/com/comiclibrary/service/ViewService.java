package com.comiclibrary.service;

import com.comiclibrary.entity.Chapter;
import com.comiclibrary.entity.ComicView;
import com.comiclibrary.repository.ChapterRepository;
import com.comiclibrary.repository.ComicViewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class ViewService {

    private final ComicViewRepository comicViewRepository;
    private final ChapterRepository chapterRepository;

    public ViewService(ComicViewRepository comicViewRepository, ChapterRepository chapterRepository) {
        this.comicViewRepository = comicViewRepository;
        this.chapterRepository = chapterRepository;
    }

    @Transactional
    public void recordChapterView(Long chapterId) {
        Chapter chapter = chapterRepository.findById(chapterId)
            .orElseThrow(() -> new com.comiclibrary.exception.ResourceNotFoundException("Chapter not found: " + chapterId));
        comicViewRepository.save(ComicView.builder()
            .comic(chapter.getComic())
            .chapter(chapter)
            .viewedAt(Instant.now())
            .build());
    }
}
