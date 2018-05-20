package com.store.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.dto.Page;
import com.store.entity.Subtype;
import com.store.service.SubtypeService;
import com.store.service.impl.SubtypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@WebServlet(name = "subtype", urlPatterns = "/subtype")
public class SubtypeServlet extends HttpServlet {

    private SubtypeService subtypeService = new SubtypeServiceImpl();
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

            List<Map<String, Object>> list = subtypeService.queryAll(page);
            ObjectMapper o = new ObjectMapper();
            String s = o.writeValueAsString(list);
            System.out.println(s);
            req.getSession().setAttribute("subtypeList", list);

            req.getSession().setAttribute("subtypePage", page);
            resp.sendRedirect("backpage/subtype/detail.jsp");
        }

        if (Objects.nonNull(action) && action.equalsIgnoreCase("getsubtype")) {
            String id = req.getParameter("id");
            Subtype subtype = subtypeService.queryById(Integer.valueOf(id));
            req.getSession().setAttribute("subTypeInfo",subtype);
            req.getRequestDispatcher("backpage/subtype/update.jsp").forward(req,resp);
        }
        //修改信息
        if (Objects.nonNull(action) && action.equalsIgnoreCase("update")) {
            String id = req.getParameter("id");
            String typeName = req.getParameter("typeName");
            String superType = req.getParameter("superType");
            Subtype subtype = new Subtype(Integer.valueOf(id),Integer.valueOf(superType),typeName);
            subtypeService.update(subtype);
            resp.sendRedirect("subtype?action=lists");
        }
        //删除类型
        if (Objects.nonNull(action) && action.equalsIgnoreCase("delete")) {
            String id = req.getParameter("id");
            subtypeService.delete(Integer.valueOf(id));
            resp.sendRedirect("subtype?action=lists");

        }
        //保存类型
        if (Objects.nonNull(action) && action.equalsIgnoreCase("save")) {
            String typeName = req.getParameter("typeName");
            String superType = req.getParameter("superType");
            Subtype subtype = new Subtype(Integer.valueOf(superType),typeName);
            subtypeService.save(subtype);
            resp.sendRedirect("subtype?action=lists");

        }

        //ajax类型
        if (Objects.nonNull(action) && action.equalsIgnoreCase("queryTypeName")) {
            List<Subtype> list = subtypeService.queryAll();
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(list);
            System.out.println("json: "+s);
            resp.getWriter().print(s);
        }
    }
}
