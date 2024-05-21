package com.busanit501.test501jsp.menu;

import com.busanit501.test501jsp.menu.dto.MenuDTO;
import com.busanit501.test501jsp.menu.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name="menuList" , urlPatterns = "/lunch/list")
public class MenuListController extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(MenuListController.class);
    private MenuService menuService = MenuService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            List<MenuDTO> sampleList = menuService.listAll();
            log.info("MenuListController , 확인2, sampleList : " + sampleList);

            // 컨트롤러에서 -> 화면에 -> 데이터 전달
            req.setAttribute("list", sampleList);
            req.getRequestDispatcher("/WEB-INF/menu/menuList.jsp")
                    .forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
