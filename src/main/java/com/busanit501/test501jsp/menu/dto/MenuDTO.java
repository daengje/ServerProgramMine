package com.busanit501.test501jsp.menu.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuDTO {
  // 인스턴스 멤버.
  private Long menuNo;
  private String menuTitle;
  private LocalDate menuRegDate;
}







