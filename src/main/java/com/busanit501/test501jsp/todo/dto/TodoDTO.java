package com.busanit501.test501jsp.todo.dto;

import lombok.*;

import java.time.LocalDate;
@Builder
// set/get/toString/equals/hashCode 등 다 포함됨.
@Data
// 인자값이 없는 생성자, 기본생성자
@NoArgsConstructor
// 모든 인자값을 가지는 생성자.
@AllArgsConstructor
public class TodoDTO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;

}
