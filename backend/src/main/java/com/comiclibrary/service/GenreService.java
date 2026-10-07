package com.comiclibrary.service;

import com.comiclibrary.dto.GenreDto;
import com.comiclibrary.repository.GenreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Transactional(readOnly = true)
    public List<GenreDto> list() {
        return genreRepository.findAll().stream().map(GenreDto::from).toList();
    }
}
