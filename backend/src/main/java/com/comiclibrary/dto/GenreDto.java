package com.comiclibrary.dto;

import com.comiclibrary.entity.Genre;

public record GenreDto(Long id, String name, String slug) {
    public static GenreDto from(Genre genre) {
        return new GenreDto(genre.getId(), genre.getName(), genre.getSlug());
    }
}
