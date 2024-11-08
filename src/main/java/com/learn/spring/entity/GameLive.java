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
public class GameLive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDateTime startDateTime;
    LocalDateTime endDateTime;
    Long activeTime;
    Float price;
    Float prizePole;
    Long gameId;
    @Column(nullable = false)
    Integer active = 0;

}
