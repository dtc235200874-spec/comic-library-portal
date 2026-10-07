package com.comiclibrary.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "chapter_pages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChapterPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chapter_id", nullable = false)
    private Chapter chapter;

    @Column(nullable = false)
    private Integer pageNumber;

    @Column(nullable = false)
    private String imageUrl;
}
