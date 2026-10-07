package com.comiclibrary.dto;

import com.comiclibrary.entity.Comic;
import com.comiclibrary.entity.ComicStatus;

import java.time.Instant;
import java.util.List;

public record ComicDto(
    Long id,
    String title,
    String alternativeTitle,
    String author,
    String description,
    String coverUrl,
    ComicStatus status,
    boolean recommended,
    Integer recommendationPriority,
    Instant createdAt,
    Instant updatedAt,
    List<GenreDto> genres
) {
    public static ComicDto from(Comic comic) {
        return new ComicDto(
            comic.getId(), comic.getTitle(), comic.getAlternativeTitle(), comic.getAuthor(),
            comic.getDescription(), comic.getCoverUrl(), comic.getStatus(), comic.isRecommended(),
            comic.getRecommendationPriority(), comic.getCreatedAt(), comic.getUpdatedAt(),
            comic.getGenres().stream().map(GenreDto::from).toList()
        );
    }
}
