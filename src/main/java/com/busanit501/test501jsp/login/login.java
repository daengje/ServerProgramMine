package com.busanit501.test501jsp.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name="login" , urlPatterns = "/login")
public class login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 로그인 입력폼으로 전달.
        System.out.println("get 으로 login 처리");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/calc/login.jsp");
        requestDispatcher.forward(req,resp);
    }

}
