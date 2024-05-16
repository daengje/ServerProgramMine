package com.busanit501.test501jsp.lunchmenu.service;

import com.busanit501.test501jsp.lunchmenu.dto.MenuDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum MenuService {

    INSTANCE;

    public List<MenuDTO> getList() {

        List<MenuDTO> listSample = IntStream.range(0,10).mapToObj(i -> {
            // 임시 Todo 하나를 의미,
            MenuDTO dto = new MenuDTO();
            dto.setMenuNo((long)i);
            dto.setMenuTitle("Sample Todo Title " + i);
            dto.setDueDate(LocalDate.now());
            return dto;
        }).collect(Collectors.toList());
        return listSample;

    }

}
