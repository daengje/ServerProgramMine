package com.busanit501.test501jsp.menu;

import com.busanit501.test501jsp.menu.dto.MenuDTO;
import com.busanit501.test501jsp.menu.service.MenuService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name="MenuController" , urlPatterns = "/lunch/input")
public class MenuRegController extends HttpServlet {

    private MenuService menuService = MenuService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/menu/menuInput.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MenuDTO menuDTO = MenuDTO.builder()
                // 화면에서, name : title
                .menuTitle(req.getParameter("title"))
                // 화면에서, name : dueDate
                .menuRegDate(LocalDate.parse(req.getParameter("dueDate")))
                .build();

        // 실제 데이터 입력하기.
        try {
            // todoDTO, 입력받은 내용을 담아서, 서비스에 보내기
            menuService.register2(menuDTO);
            // 리다이렉트, 메인: 리스트
            resp.sendRedirect("/lunch/list");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
