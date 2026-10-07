package com.comiclibrary.repository;

import com.comiclibrary.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {
    List<Chapter> findByComicIdOrderByChapterNumberDesc(Long comicId);
}
