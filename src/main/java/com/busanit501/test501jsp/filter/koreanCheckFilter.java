package com.busanit501.test501jsp.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebServlet(urlPatterns = {"/*"})
//public class KoreanCheckFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//        HttpServletRequest req  = (HttpServletRequest)servletRequest;
//        req.setCharacterEncoding("UTF-8");
//// 필터 체인이라는 인스턴스에 적용한다.
//        filterChain.doFilter(servletRequest,servletResponse);
//    }
//}

@WebFilter(urlPatterns = {"/*"})
public class koreanCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 한글 UTF-8 설정.
        // ServletRequest(부모) 는  HttpServletRequest(자식) 의 상위 개념.
        HttpServletRequest req  = (HttpServletRequest)servletRequest;
        req.setCharacterEncoding("UTF-8");
// 필터 체인이라는 인스턴스에 적용한다.
        filterChain.doFilter(servletRequest,servletResponse);

    }
}