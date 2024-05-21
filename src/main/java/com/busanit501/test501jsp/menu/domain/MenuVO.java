package com.busanit501.test501jsp.menu.domain;

import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Builder
@NoArgsConstructor //기본생성자
@AllArgsConstructor //다있는생성자
public class MenuVO {
  // 인스턴스 멤버.
  private Long menuNo;
  private String menuTitle;
  private LocalDate menuRegDate;
}







