package com.store.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.dto.Page;
import com.store.entity.Goods;
import com.store.service.GoodsService;
import com.store.service.GoodsService;
import com.store.service.impl.GoodsServiceImpl;
import com.store.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
@WebServlet(name = "GoodsServlet",urlPatterns = "/goods")
@MultipartConfig
public class GoodsServlet extends HttpServlet {

    private GoodsService goodsService = new GoodsServiceImpl();
    //获取文件的信息
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String curpage = req.getParameter("curpage");
        System.out.println("action:"+action);

        //获取分页信息一页显示4个
        if (Objects.nonNull(action) && action.equalsIgnoreCase("ajaxlists")) {
            if (Objects.isNull(curpage)) {
                curpage = "1";
            }

            Page page = new Page(Integer.valueOf(curpage), 2);

            List<Map<String, Object>> list = goodsService.queryAll(page);
            ObjectMapper o = new ObjectMapper();
            String s = o.writeValueAsString(list);

           resp.getWriter().print(s);
        }

        //ajax
        if (Objects.nonNull(action) && action.equalsIgnoreCase("lists")) {
            if (Objects.isNull(curpage)) {
                curpage = "1";
            }

            Page page = new Page(Integer.valueOf(curpage), 4);

            List<Map<String, Object>> list = goodsService.queryAll(page);
            ObjectMapper o = new ObjectMapper();
            String s = o.writeValueAsString(list);
            System.out.println("进去了吗");
            req.getSession().setAttribute("goodsList", list);

            req.getSession().setAttribute("goodsPage", page);
            resp.sendRedirect("backpage/goods/detail.jsp");
        }

        if (Objects.nonNull(action) && action.equalsIgnoreCase("getgoods")) {
            String id = req.getParameter("id");
            Goods goods = goodsService.queryById(Integer.valueOf(id));
            req.getSession().setAttribute("goodsInfo",goods);
            req.getRequestDispatcher("backpage/goods/update.jsp").forward(req,resp);
        }
        //修改信息
        if (Objects.nonNull(action) && action.equalsIgnoreCase("update")) {
            String tid = req.getParameter("tid");
            String name = req.getParameter("name");
            String introduce = req.getParameter("introduce");
            Goods goods = new Goods();
            goodsService.update(goods);
            resp.sendRedirect("goods?action=lists");
        }
        //删除类型
        if (Objects.nonNull(action) && action.equalsIgnoreCase("delete")) {
            String id = req.getParameter("id");
            goodsService.delete(Integer.valueOf(id));
            resp.sendRedirect("goods?action=lists");

        }
        //保存类型
        if (Objects.nonNull(action) && action.equalsIgnoreCase("save")) {
            String tid = req.getParameter("tid");
            String name = req.getParameter("name");
            String introduce = req.getParameter("introduce");
            String price = req.getParameter("price");
            String reducePrice = req.getParameter("reducePrice");
            if (Objects.isNull(reducePrice) || reducePrice.equals("")){
                reducePrice = "0";
            }
            System.out.println("reducePrice"+reducePrice);
            Part photoPart = req.getPart("photo");
            String fileName = getFileName(photoPart);
            String photo = req.getServletContext().getRealPath("/")+"goods";
           // String photo = "E:/project/gopic";
            File file = new File(photo);
            if (!file.exists()){
                file.mkdirs();
            }
            photoPart.write(photo+"/"+fileName);
            Goods goods = new Goods();
            System.out.println(goods);
            goodsService.save(goods);
            resp.sendRedirect("goods?action=lists");

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
