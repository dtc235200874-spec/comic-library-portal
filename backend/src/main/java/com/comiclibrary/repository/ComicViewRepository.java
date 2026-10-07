package com.comiclibrary.repository;

import com.comiclibrary.entity.ComicView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;

public interface ComicViewRepository extends JpaRepository<ComicView, Long> {

    @Query("SELECT v.comic.id, COUNT(v) FROM ComicView v WHERE v.viewedAt >= :since GROUP BY v.comic.id ORDER BY COUNT(v) DESC")
    List<Object[]> countViewsSince(@Param("since") Instant since);
}
