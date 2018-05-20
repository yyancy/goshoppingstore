package com.store.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.dto.Page;
import com.store.entity.Supertype;
import com.store.service.SupertypeService;
import com.store.service.impl.SupertypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "supertype", urlPatterns = "/supertype")
public class SupertypeServlet extends HttpServlet {

    private SupertypeService supertypeService = new SupertypeServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String curpage = req.getParameter("curpage");
        System.out.println("action:"+action);
        //获取分页信息一页显示4个
        if (Objects.nonNull(action) && action.equalsIgnoreCase("lists")) {
            if (Objects.isNull(curpage)) {
                curpage = "1";
            }
            Page page = new Page(Integer.valueOf(curpage), 4);
            System.out.println("action:" + action + "curpage:" + curpage);

            List<Supertype> list = supertypeService.queryAll(page);
            req.getSession().setAttribute("supertypeList", list);
            req.getSession().setAttribute("supertypePage", page);
            resp.sendRedirect("backpage/supertype/detail.jsp");
        }

        if (Objects.nonNull(action) && action.equalsIgnoreCase("getsupertype")) {
            System.out.println("进去了吗");
            String id = req.getParameter("id");
            Supertype supertype = supertypeService.queryById(Integer.valueOf(id));
            req.getSession().setAttribute("superTypeInfo",supertype);
            req.getRequestDispatcher("backpage/supertype/update.jsp").forward(req,resp);
        }
        //修改信息
        if (Objects.nonNull(action) && action.equalsIgnoreCase("update")) {
            String id = req.getParameter("id");
            String typeName = req.getParameter("typeName");
            Supertype supertype = new Supertype(Integer.valueOf(id),typeName);
            supertypeService.update(supertype);
            resp.sendRedirect("supertype?action=lists");
        }
        //删除类型
        if (Objects.nonNull(action) && action.equalsIgnoreCase("delete")) {
            String id = req.getParameter("id");
            supertypeService.delete(Integer.valueOf(id));
            resp.sendRedirect("supertype?action=lists");

        }
        //添加类型
        if (Objects.nonNull(action) && action.equalsIgnoreCase("save")) {
            String typeName = req.getParameter("typeName");
            Supertype supertype = new Supertype(typeName);
            supertypeService.save(supertype);
            resp.sendRedirect("supertype?action=lists");

        }

        //ajax类型
        if (Objects.nonNull(action) && action.equalsIgnoreCase("queryTypeName")) {
            List<Supertype> list = supertypeService.queryTypes();
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(list);
            System.out.println("json: "+s);
            resp.getWriter().print(s);
        }
    }
}
