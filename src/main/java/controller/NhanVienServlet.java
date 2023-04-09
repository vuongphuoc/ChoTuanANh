package controller;

import domainModel.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.NhanVienRepository;

import java.io.IOException;

@WebServlet({
        "/nhan-vien/create",
        "/nhan-vien/edit",
        "/nhan-vien/update",
        "/nhan-vien/store",
        "/nhan-vien/index",
        "/nhan-vien/delete",
})
public class NhanVienServlet extends HttpServlet {
    private NhanVienRepository nhanVienRepository;

    public NhanVienServlet() {
        nhanVienRepository = new NhanVienRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            create(request, response);
        } else if (uri.contains("edit")) {
            edit(request,response);
        }else if (uri.contains("delete")){
            delete(request,response);
        }else{
            index(request,response);
        }
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/nhan_vien/create.jsp").forward(request,response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/TEMPLATE_FINAL_war_exploded/cua-hang/index");

    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhSachNV",nhanVienRepository.findAll());
        request.getRequestDispatcher("/view/nhan_vien/index.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            store(request, response);
        } else if (uri.contains("update")) {
            update(request,response);
        }else{
            response.sendRedirect("/TEMPLATE_FINAL_war_exploded/cua-hang/index");
        }
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            NhanVien nhanVien = new NhanVien();
            BeanUtils.populate(nhanVien,request.getParameterMap());
            nhanVienRepository.insert(nhanVien);
        }catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/TEMPLATE_FINAL_war_exploded/cua-hang/index");

    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            NhanVien nhanVien = nhanVienRepository.findByMa(ma);
            BeanUtils.populate(nhanVien,request.getParameterMap());
            nhanVienRepository.update(nhanVien);
        }catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/TEMPLATE_FINAL_war_exploded/cua-hang/index");
    }
}
