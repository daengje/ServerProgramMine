package com.busanit501.test501jsp.todo.domain;

import lombok.*;

import java.time.LocalDate;


@Getter

@Builder

@NoArgsConstructor
@AllArgsConstructor

public class TodoVO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
};
