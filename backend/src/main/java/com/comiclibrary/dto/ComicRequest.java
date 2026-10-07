package com.comiclibrary.dto;

import com.comiclibrary.entity.ComicStatus;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public record ComicRequest(
    @NotBlank String title,
    String alternativeTitle,
    String author,
    String description,
    String coverUrl,
    ComicStatus status,
    Boolean recommended,
    Integer recommendationPriority,
    Set<Long> genreIds
) {
}
