/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.DiaPhuongDAO;
import model.dao.NguoiPhuTrachDAO;
import model.dao.VanBanDAO;
import model.dao.service.DiaPhuongDAOService;
import model.dao.service.NguoiPhuTrachDAOService;
import model.dao.service.VanBanDAOService;
import model.entities.DiaPhuong;
import model.entities.NguoiPhuTrach;
import model.entities.VanBan;

/**
 *
 * @author Admin
 */
public class SearchServlet extends HttpServlet {

    DiaPhuongDAOService DP_SERVICE = DiaPhuongDAO.getInstance();
    NguoiPhuTrachDAOService NPT_SERVICE = NguoiPhuTrachDAO.getInstance();
    VanBanDAOService VB_SERVICE = VanBanDAO.getInstance();

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    private void searchDP_CB(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String result = request.getParameter("timkiem");
        String tenDP = request.getParameter("diaphuong");
        DiaPhuong dp = DP_SERVICE.getDiaPhuongByTenDP(tenDP);
        List<NguoiPhuTrach> nptList = dp.getNptList();
//        float danSo = dp.getSoDan();
//        float dienTich = dp.getDienTich();
        request.setAttribute("dp", dp);
        List<DiaPhuong> dpList = DP_SERVICE.getDiaPhuongAll();
        request.setAttribute("nptList", nptList);
        request.setAttribute(util.Constants.DP_LIST, dpList);
        request.setAttribute(util.Constants.PAGE, "search-cb-dp");
        request.removeAttribute(util.Constants.MSG_RESULT);
        request.getRequestDispatcher(util.Constants.URL_HOME).forward(request, response);
    }

    private void searchVB_CB(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String tenVB = request.getParameter("tenVB");
        List<VanBan> vb = VB_SERVICE.getVanBanByTenVB(tenVB);
        request.setAttribute(util.Constants.PAGE, "search-cb-vb");
        request.removeAttribute(util.Constants.MSG_RESULT);
        request.getRequestDispatcher(util.Constants.URL_HOME).forward(request, response);
    }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("do");
        switch (action) {
            case "tk-dp-cb":
                searchDP_CB(request, response);
                break;
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
