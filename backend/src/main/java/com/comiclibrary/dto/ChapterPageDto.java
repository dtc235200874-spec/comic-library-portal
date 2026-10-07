package com.comiclibrary.dto;

import com.comiclibrary.entity.ChapterPage;

import java.util.List;

public record ChapterPageDto(Long id, Integer pageNumber, String imageUrl) {
    public static ChapterPageDto from(ChapterPage page) {
        return new ChapterPageDto(page.getId(), page.getPageNumber(), page.getImageUrl());
    }

    public static List<ChapterPageDto> from(List<ChapterPage> pages) {
        return pages.stream().map(ChapterPageDto::from).toList();
    }
}
