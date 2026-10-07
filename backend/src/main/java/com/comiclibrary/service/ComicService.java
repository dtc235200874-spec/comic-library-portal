package com.comiclibrary.service;

import com.comiclibrary.dto.ComicDto;
import com.comiclibrary.dto.ComicRequest;
import com.comiclibrary.entity.Comic;
import com.comiclibrary.entity.Genre;
import com.comiclibrary.exception.ResourceNotFoundException;
import com.comiclibrary.repository.ComicRepository;
import com.comiclibrary.repository.GenreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class ComicService {

    private final ComicRepository comicRepository;
    private final GenreRepository genreRepository;

    public ComicService(ComicRepository comicRepository, GenreRepository genreRepository) {
        this.comicRepository = comicRepository;
        this.genreRepository = genreRepository;
    }

    @Transactional(readOnly = true)
    public List<ComicDto> list() {
        return comicRepository.findAll().stream().map(ComicDto::from).toList();
    }

    @Transactional(readOnly = true)
    public ComicDto get(Long id) {
        return ComicDto.from(find(id));
    }

    @Transactional(readOnly = true)
    public Comic find(Long id) {
        return comicRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comic not found: " + id));
    }

    @Transactional(readOnly = true)
    public List<ComicDto> latest() {
        return comicRepository.findAll().stream()
            .sorted((a, b) -> cmpNullSafe(b.getCreatedAt(), a.getCreatedAt()))
            .map(ComicDto::from).toList();
    }

    @Transactional(readOnly = true)
    public List<ComicDto> popular() {
        return list();
    }

    @Transactional(readOnly = true)
    public List<ComicDto> recommended() {
        return comicRepository.findAll().stream()
            .filter(Comic::isRecommended)
            .map(ComicDto::from).toList();
    }

    @Transactional
    public ComicDto create(ComicRequest request) {
        Comic comic = Comic.builder()
            .title(request.title())
            .alternativeTitle(request.alternativeTitle())
            .author(request.author())
            .description(request.description())
            .coverUrl(request.coverUrl())
            .status(request.status())
            .isRecommended(Boolean.TRUE.equals(request.recommended()))
            .recommendationPriority(request.recommendationPriority())
            .build();
        if (request.genreIds() != null) {
            Set<Genre> genres = Set.copyOf(genreRepository.findAllById(request.genreIds()));
            comic.getGenres().addAll(genres);
        }
        return ComicDto.from(comicRepository.save(comic));
    }

    @Transactional
    public ComicDto update(Long id, ComicRequest request) {
        Comic comic = find(id);
        comic.setTitle(request.title());
        comic.setAlternativeTitle(request.alternativeTitle());
        comic.setAuthor(request.author());
        comic.setDescription(request.description());
        comic.setCoverUrl(request.coverUrl());
        comic.setStatus(request.status());
        if (request.recommended() != null) comic.setRecommended(request.recommended());
        comic.setRecommendationPriority(request.recommendationPriority());
        if (request.genreIds() != null) {
            comic.getGenres().clear();
            comic.getGenres().addAll(genreRepository.findAllById(request.genreIds()));
        }
        return ComicDto.from(comicRepository.save(comic));
    }

    public void delete(Long id) {
        comicRepository.delete(find(id));
    }

    private static int cmpNullSafe(java.time.Instant a, java.time.Instant b) {
        if (a == null && b == null) return 0;
        if (a == null) return -1;
        if (b == null) return 1;
        return a.compareTo(b);
    }
}
