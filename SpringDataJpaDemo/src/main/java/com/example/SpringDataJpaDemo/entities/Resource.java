package com.example.SpringDataJpaDemo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Resource {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer size;

    private String url;

    @OneToOne()
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
}
