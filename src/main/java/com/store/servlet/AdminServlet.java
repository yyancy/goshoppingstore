package com.store.servlet;

import com.store.entity.Admin;
import com.store.service.AdminService;
import com.store.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {

    private AdminService adminService = new AdminServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        //admin be register
        if (Objects.nonNull(action) && action.equalsIgnoreCase("register")) {
            String name = request.getParameter("name");
            String pwd = request.getParameter("pwd");
            adminService.save(new Admin(name, pwd));
            request.getRequestDispatcher("backpage/index.jsp").forward(request, response);
        }

        //admin be login
        if (Objects.nonNull(action) && action.equalsIgnoreCase("login")) {
            String name = request.getParameter("name");
            String pwd = request.getParameter("pwd");
            Integer adminId = adminService.login(name, pwd);
            if (Objects.nonNull(adminId)) {
                System.out.println("进入了");

                request.getSession().setAttribute("name", name);
                request.getSession().setAttribute("adminId", adminId);
                request.getRequestDispatcher("backpage/index.jsp").forward(request, response);

            } else {
                request.getRequestDispatcher("backpage/login.jsp").forward(request, response);
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response){

    }
}
