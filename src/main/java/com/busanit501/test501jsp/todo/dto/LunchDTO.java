package com.busanit501.test501jsp.todo.dto;

import java.time.LocalDate;

public class LunchDTO {
    private Long menuNo;
    private String menuTitle;
    private LocalDate menuRegDate;

    @Override
    public String toString() {
        return "LunchDTO{" +
                "menuNo=" + menuNo +
                ", menuTitle='" + menuTitle + '\'' +
                ", menuRegDate=" + menuRegDate +
                '}';
    }

    public Long getMenuNo() {
        return menuNo;
    }

    public void setMenuNo(Long menuNo) {
        this.menuNo = menuNo;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public LocalDate getMenuRegDate() {
        return menuRegDate;
    }

    public void setMenuRegDate(LocalDate menuRegDate) {
        this.menuRegDate = menuRegDate;
    }
}