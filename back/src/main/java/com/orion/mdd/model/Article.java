package com.orion.mdd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Lob
    private String content;

    private LocalDate datePublication;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User author;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Topic topic;
}