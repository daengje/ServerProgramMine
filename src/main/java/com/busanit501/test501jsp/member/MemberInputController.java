package com.busanit501.test501jsp.member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "MemberInputController", urlPatterns = "/member/input")
public class MemberInputController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/member/memberInput.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/member/list");

        String memberName1 = req.getParameter("member1");
        String memberName2 = req.getParameter("member2");
        System.out.println("받은 메뉴값 출력 member1: " + memberName1 + ", 메뉴값 출력 member2: " + memberName2  );
    }
}
