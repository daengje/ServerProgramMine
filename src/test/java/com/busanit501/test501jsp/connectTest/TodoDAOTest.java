package com.busanit501.test501jsp.connectTest;

import com.busanit501.test501jsp.todo.dao.TodoDAO;
import com.busanit501.test501jsp.todo.domain.TodoVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class TodoDAOTest {

    private TodoDAO todoDAO;

    @BeforeEach
    public void ready() throws Exception {
        todoDAO = new TodoDAO();
    }

    @Test
    public void getTimeTest() throws Exception {
        //todoDAO = new TodoDAO();
        //String time = todoDAO.getTime();
        String time = todoDAO.getTime2();
        System.out.println("time: " + time);
    }

    @Test
    public void getSelectAll() throws Exception {
        List<TodoVO> samples = todoDAO.selectAll();
        System.out.println("samples: " + samples);
        samples.forEach(vo -> System.out.println("각각 출력" + vo));
    }

    //insert
    @Test
    public void insert() throws Exception {
        TodoVO todovo = TodoVO.builder()
                .title("오늘 점심 뭐먹지?")
                .dueDate(LocalDate.of(2024,5,20))
                .finished(false)
                .build();
    }
    @Test
    public void delete() throws Exception {
        todoDAO.delete(1L);
    }

    @Test
    public void update() throws Exception {
        TodoVO todoVO1 = TodoVO.builder()
                .tno(2L)
                .title("점심모름")
                .dueDate(LocalDate.now())
//      .dueDate(LocalDate.of(2024,5,20))
                .finished(false)
                .build();

        // 기능구현
        todoDAO.update(todoVO1);
    }

}
