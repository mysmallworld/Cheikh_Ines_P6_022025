package com.orion.mdd.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article extends Auditable  {
    @Id
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