package com.busanit501.test501jsp.todo.domain;

import lombok.*;

import java.time.LocalDate;

@Getter

@Builder

@NoArgsConstructor
@AllArgsConstructor

public class LunchVO {
    private Long menuNo;
    private String menuTitle;
    private LocalDate menuRegDate;
}
