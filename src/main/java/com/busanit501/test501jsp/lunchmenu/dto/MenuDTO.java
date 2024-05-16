package com.busanit501.test501jsp.lunchmenu.dto;

import java.time.LocalDate;

public class MenuDTO {
    private Long menuNo;
    private String menuTitle;
    private LocalDate dueDate;

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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "menuNo=" + menuNo +
                ", menuTitle='" + menuTitle + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }
}
