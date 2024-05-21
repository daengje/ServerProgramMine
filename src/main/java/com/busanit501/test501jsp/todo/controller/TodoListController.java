package com.busanit501.test501jsp.todo.controller;

import com.busanit501.test501jsp.todo.dto.TodoDTO;
import com.busanit501.test501jsp.todo.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "todoList",urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(TodoListController.class);
    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 목록 화면으로 전달,
        // 더미 데이터 10개 이용해서, 브라우저에게 전달하기.
        try {
            List<TodoDTO> sampleList = todoService.listAll();
            log.info("TodoListController , 확인2, sampleList : " + sampleList);

            // 컨트롤러에서 -> 화면에 -> 데이터 전달
            req.setAttribute("list", sampleList);
            req.getRequestDispatcher("/WEB-INF/todo/todoList.jsp")
                    .forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}




