package com.store.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.dto.Page;
import com.store.entity.Order;
import com.store.service.OrderService;
import com.store.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@WebServlet(name = "OrderServlet",urlPatterns = "/order")
public class OrderServlet extends HttpServlet {

    private OrderService orderService = new OrderServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String curpage = req.getParameter("curpage");
        System.out.println("action:"+action);

        //获取分页信息一页显示4个
        if (Objects.nonNull(action) && action.equalsIgnoreCase("lists")) {
            if (Objects.isNull(curpage)) {
                curpage = "1";
            }

            System.out.println("order lists is in");
            Page page = new Page(Integer.valueOf(curpage), 4);
            System.out.println("action:" + action + "curpage:" + curpage);

            List<Map<String, Object>> list = orderService.queryAll(page);
            ObjectMapper o = new ObjectMapper();
            String s = o.writeValueAsString(list);
            System.out.println("list: "+list);
            System.out.println(s);
            req.getSession().setAttribute("orderList", list);

            req.getSession().setAttribute("orderPage", page);
            resp.sendRedirect("backpage/order/detail.jsp");
        }

        if (Objects.nonNull(action) && action.equalsIgnoreCase("getorder")) {
            String id = req.getParameter("id");

            Order order = orderService.queryById(Integer.valueOf(id));
            //req.getSession().setAttribute("orderInfo",order);
           // req.getRequestDispatcher("backpage/order/update.jsp").forward(req,resp);
        }


        //修改信息
        if (Objects.nonNull(action) && action.equalsIgnoreCase("update")) {
            String tid = req.getParameter("tid");
            String name = req.getParameter("name");
            String introduce = req.getParameter("introduce");
            Order order = new Order();
            //orderService.update(order);
            resp.sendRedirect("order?action=lists");
        }
        //删除类型
        if (Objects.nonNull(action) && action.equalsIgnoreCase("delete")) {
            String id = req.getParameter("id");
            orderService.delete(Integer.valueOf(id));
            resp.sendRedirect("order?action=lists");

        }
        //保存类型
        if (Objects.nonNull(action) && action.equalsIgnoreCase("save")) {
            String tid = req.getParameter("gid");
            String number = req.getParameter("number");
            String address = req.getParameter("address");
            String qq = req.getParameter("qq");
            String telephone = req.getParameter("telephone");
            String payType = req.getParameter("payType");
            String bz = req.getParameter("bz");
            Object name = req.getSession().getAttribute("name");
            if (Objects.isNull(name) || name.equals("")){
                resp.sendRedirect("index.jsp");
            }
            Order o = new Order();
            resp.sendRedirect("order?action=lists");

        }

        if (Objects.nonNull(action) && action.equals("upstate")){
            String id = req.getParameter("id");
            String state = req.getParameter("state");
            if (state.equals("1")){
                state = "2";
            } else if (state.equals("2")) {
                state = "3";
            }
            orderService.upstate(Integer.valueOf(id),Integer.valueOf(state));
            resp.sendRedirect("order?action=lists");
        }
    }
}
