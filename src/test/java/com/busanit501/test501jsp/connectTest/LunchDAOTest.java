package com.busanit501.test501jsp.connectTest;

import com.busanit501.test501jsp.todo.dao.LunchDAO;
import com.busanit501.test501jsp.todo.domain.LunchVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class LunchDAOTest {
    private LunchDAO lunchDAO;

    @BeforeEach
    public void ready(){
        lunchDAO = new LunchDAO();
    }



    @Test
    public void getSelectAll() throws Exception {
        List<LunchVO> samples = lunchDAO.selectAll();
        System.out.println("samples: " + samples);
        samples.forEach(vo -> System.out.println("각각 출력" + vo));
    }

    @Test
    public void getSelectOne() throws Exception {
        LunchVO lunchVO = lunchDAO.selectOne(1L);
        System.out.println("lunchVO: " + lunchVO);
    }

    @Test
    public void insert() throws Exception {
        LunchVO lunchVO1 = LunchVO.builder()
                .menuTitle("메뉴이름")
                .menuRegDate(LocalDate.of(2024,5,20))
                .build();
        lunchDAO.insert(lunchVO1);
    }

    @Test
    public void update() throws Exception {
        LunchVO lunchVO1 = LunchVO.builder()
                .menuNo(1L)
                .menuTitle("밥먹을수있을까")
                .menuRegDate(LocalDate.of(2024,5,20))
                .build();

        lunchDAO.update(lunchVO1);
    }

    @Test
    public void delete() throws Exception {
        lunchDAO.delete(1L);
    }
}
