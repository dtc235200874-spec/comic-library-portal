package com.comiclibrary.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.Instant;

public record ChapterRequest(
    @NotNull BigDecimal chapterNumber,
    String title,
    Instant publishedAt
) {
}
