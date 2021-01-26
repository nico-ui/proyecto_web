package com.ipn.escom.mx.controlador.web;

import com.ipn.escom.mx.modelo.dao.PersonalMedicoDAO;
import com.ipn.escom.mx.modelo.dto.PersonalMedicoDTO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cristopher Salas
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        
        switch (accion) {
            case "login":
                PersonalMedicoDAO dao = new PersonalMedicoDAO();
                PersonalMedicoDTO dto = new PersonalMedicoDTO();
        
                dto.getEntidad().setEmail(request.getParameter("email"));
                dto.getEntidad().setClave(request.getParameter("password"));

                String nombreUsuario = dto.getEntidad().getEmail();
                
                try {
                    dto = dao.findUser(dto);
                } catch (SQLException ex) {
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                if(dto != null){
                    String idUsuario = dto.getEntidad().getEmail();
                    login(request,response,nombreUsuario,idUsuario);
                    RequestDispatcher rd = request.getRequestDispatcher("loginExito.jsp");
                    rd.forward(request, response);
                    response.sendRedirect("LoginServlet?accion=loginExito");
                }
                else{
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    try {
                        rd.forward(request, response);
                    } catch (ServletException | IOException ex) {
                        Logger.getLogger(LoginServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                }
                break;
            case "logout":
                logout(request,response);
                RequestDispatcher RD = request.getRequestDispatcher("index.jsp");
                    try {
                        RD.forward(request, response);
                    } catch (ServletException | IOException ex) {
                        Logger.getLogger(LoginServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                break;
            case "loginExito":
                RequestDispatcher rd = request.getRequestDispatcher("loginExito.jsp");
                    try {
                        rd.forward(request, response);
                    } catch (ServletException | IOException ex) {
                        Logger.getLogger(LoginServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                break;
            default:
                break;
        }

}


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
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

    
    private final static String LOGIN_NAME_SESSION_ATTRIBUTE = "usuarioLogueado";
    private final static String LOGIN_ID_SESSION_ATTRIBUTE = "idLogueado";
    
    public void login(HttpServletRequest request, HttpServletResponse response, String nombreUsuario, String idUsuario){
        HttpSession session = request.getSession(true);
        session.setAttribute(LOGIN_NAME_SESSION_ATTRIBUTE,nombreUsuario);
        session.setAttribute(LOGIN_ID_SESSION_ATTRIBUTE,idUsuario);
    }
    
    public void logout(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession(false);
        session.removeAttribute("usuarioLogueado");
        session.removeAttribute("idLogueado");
        if(session != null){
            session.invalidate();
        }
    }
    
    public boolean getLoginName(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession(false);
        if(session == null){
            return false;
        }else{
            return session.getAttribute(LOGIN_NAME_SESSION_ATTRIBUTE) != null;
        }
    }
}
