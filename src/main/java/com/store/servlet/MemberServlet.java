package com.store.servlet;

import com.store.entity.Member;
import com.store.service.MemberService;
import com.store.service.impl.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(name = "MemberServlet", urlPatterns = "/member")
public class MemberServlet extends HttpServlet {
    private MemberService memberService = new MemberServiceImpl();

    //post   添加主要的逻辑
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equalsIgnoreCase("register")) {
            String name = request.getParameter("name");
            String realName = request.getParameter("realName");
            String pwd = request.getParameter("pwd");
            String city = request.getParameter("city");
            String address = request.getParameter("address");
            String idCard = request.getParameter("idCard");
            String jobType = request.getParameter("jobType");
            String qq = request.getParameter("qq");
            String telephone = request.getParameter("telephone");
            String email = request.getParameter("email");
            Member member = new Member(name, realName, pwd, city, address, idCard, jobType, qq, telephone, email);
            memberService.save(member);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }


        if (action != null && action.equalsIgnoreCase("login")) {
            String name = request.getParameter("name");
            String pwd = request.getParameter("pwd");
            Integer memberId = memberService.login(name, pwd);
            if (memberId != null) {
                request.getSession().setAttribute("name", name);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        }
    }

    private String getFileName(Part part) {
        String content = part.getHeader("content-disposition");
        String[] split = content.split(";");
        for (String s : split) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf('=') + 1)
                        .trim().replace("\"", "");
            }
        }
        return null;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
