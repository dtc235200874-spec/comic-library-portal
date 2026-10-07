package com.comiclibrary.dto;

import com.comiclibrary.entity.Chapter;

import java.util.List;

public record ChapterDetailDto(ChapterDto chapter, List<ChapterPageDto> pages) {
    public static ChapterDetailDto from(Chapter chapter) {
        return new ChapterDetailDto(ChapterDto.from(chapter), ChapterPageDto.from(List.copyOf(chapter.getPages())));
    }
}
