package controller;

import domainModel.CuaHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.CuaHangRepository;

import java.io.IOException;

@WebServlet({
        "/cua-hang/index",
        "/cua-hang/create",
        "/cua-hang/delete",
        "/cua-hang/edit",
        "/cua-hang/store",
        "/cua-hang/update",
})
public class CuaHangServlet extends HttpServlet {

    private CuaHangRepository cuaHangRepository;
    public CuaHangServlet(){
        cuaHangRepository = new CuaHangRepository();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("create")){
            create(request,response);
        }else if(uri.contains("delete")){
            delete(request,response);
        }else  if (uri.contains("edit")) {
            edit(request,response);
        }else {
            index(request,response);
        }
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/cua_hang/create.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        CuaHang ch =cuaHangRepository.findByMa(ma);
        cuaHangRepository.delete(ch);
        response.sendRedirect("/TEMPLATE_FINAL_war_exploded/cua-hang/index");

    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        CuaHang ch =cuaHangRepository.findByMa(ma);
        request.setAttribute("ch",ch);
        request.getRequestDispatcher("/view/cua_hang/edit.jsp").forward(request,response);
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setAttribute("danhSachCH",cuaHangRepository.findAll());
        request.getRequestDispatcher("/view/cua_hang/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("store")){
            store(request,response);
        }else if(uri.contains("update")){
            update(request,response);
        }else{
            response.sendRedirect("/TEMPLATE_FINAL_war_exploded/cua-hang/index");
        }
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            CuaHang ch = new CuaHang();
            BeanUtils.populate(ch,request.getParameterMap());
            cuaHangRepository.insert(ch);
        }catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/TEMPLATE_FINAL_war_exploded/cua-hang/index");

    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String ma =request.getParameter("ma");
            CuaHang ch =cuaHangRepository.findByMa(ma);
            BeanUtils.populate(ch,request.getParameterMap());
            cuaHangRepository.insert(ch);
        }catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/TEMPLATE_FINAL_war_exploded/cua-hang/index");
    }
}
