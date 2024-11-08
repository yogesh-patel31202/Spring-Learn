package com.learn.spring.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    LocalDateTime startDateTime = LocalDateTime.now();
    Long activeTime;
    @Column(nullable = false)
    Boolean active = true;
    Float price;
    Float prizePole;

}
