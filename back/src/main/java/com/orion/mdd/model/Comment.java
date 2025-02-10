package com.orion.mdd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Lob
    private String content;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User author;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Article article;
}