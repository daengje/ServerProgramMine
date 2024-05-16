package com.busanit501.test501jsp.lunchmenu;

import com.busanit501.test501jsp.lunchmenu.dto.MenuDTO;
import com.busanit501.test501jsp.lunchmenu.service.MenuService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name="menuList" , urlPatterns = "/lunch/list")
public class MenuController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<MenuDTO> sampleList = MenuService.INSTANCE.getList();
        req.setAttribute("list",sampleList);


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/menu/menuList.jsp");
        requestDispatcher.forward(req, resp);
    }
}
