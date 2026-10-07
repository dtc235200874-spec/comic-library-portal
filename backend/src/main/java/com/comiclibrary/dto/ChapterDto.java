package com.comiclibrary.dto;

import com.comiclibrary.entity.Chapter;

import java.math.BigDecimal;
import java.time.Instant;

public record ChapterDto(
    Long id,
    Long comicId,
    BigDecimal chapterNumber,
    String title,
    Instant publishedAt,
    Instant createdAt,
    Instant updatedAt
) {
    public static ChapterDto from(Chapter chapter) {
        return new ChapterDto(
            chapter.getId(), chapter.getComic().getId(), chapter.getChapterNumber(),
            chapter.getTitle(), chapter.getPublishedAt(), chapter.getCreatedAt(), chapter.getUpdatedAt()
        );
    }
}
