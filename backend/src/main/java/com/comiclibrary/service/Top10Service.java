package com.comiclibrary.service;

import com.comiclibrary.dto.ComicDto;
import com.comiclibrary.repository.ComicRepository;
import com.comiclibrary.repository.ComicViewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class Top10Service {

    private static final int LIMIT = 10;

    private final ComicViewRepository viewRepository;
    private final ComicRepository comicRepository;

    public Top10Service(ComicViewRepository viewRepository, ComicRepository comicRepository) {
        this.viewRepository = viewRepository;
        this.comicRepository = comicRepository;
    }

    @Transactional(readOnly = true)
    public List<ComicDto> top10(String period) {
        Instant since = switch (period == null ? "month" : period.toLowerCase()) {
            case "day" -> Instant.now().minus(1, ChronoUnit.DAYS);
            case "week" -> Instant.now().minus(7, ChronoUnit.DAYS);
            case "month" -> Instant.now().minus(30, ChronoUnit.DAYS);
            default -> Instant.EPOCH;
        };
        return viewRepository.countViewsSince(since).stream()
            .map(row -> ((Number) row[0]).longValue())
            .map(comicRepository::findById)
            .flatMap(java.util.Optional::stream)
            .map(ComicDto::from)
            .limit(LIMIT)
            .toList();
    }

}
