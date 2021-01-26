/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.escom.mx.controlador.web;

import com.ipn.escom.mx.modelo.dao.EspecialidadDAO;
import com.ipn.escom.mx.modelo.dao.PersonalMedicoDAO;
import com.ipn.escom.mx.modelo.dto.PersonalMedicoDTO;
import com.ipn.escom.mx.utilerias.EnviarMail;
import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet(name = "PersonalMedicoExternoServlet", urlPatterns = {"/PersonalMedicoExternoServlet"})
public class PersonalMedicoExternoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        if (accion.equals("registroNuevo")) {
            registroNuevo(request, response);
        } else {
            if (accion.equals("confirmacion")) {
                confirmacion(request, response);
            } else {
                if (accion.equals("listaE")) {
                    listaDeEspecialidades(request, response);
                }
            }
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

    private void listaDeEspecialidades(HttpServletRequest request, HttpServletResponse response) {
        EspecialidadDAO dao = new EspecialidadDAO();

        try {
            List lista = dao.readAll();
            request.setAttribute("listaDeEspecialidades", lista);
            RequestDispatcher vista = request.getRequestDispatcher("nuevoPersonalMedicoE.jsp");
            vista.forward(request, response);
        } catch (ServletException | IOException | SQLException ex) {
            Logger.getLogger(PersonalMedicoExternoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void registroNuevo(HttpServletRequest request, HttpServletResponse response) {
        PersonalMedicoDTO dto = new PersonalMedicoDTO();
        PersonalMedicoDAO dao = new PersonalMedicoDAO();

        dto.getEntidad().setNombre(request.getParameter("nombre"));
        dto.getEntidad().setPaterno(request.getParameter("paterno"));
        dto.getEntidad().setMaterno(request.getParameter("materno"));
        dto.getEntidad().setCedula(request.getParameter("cedula"));
        dto.getEntidad().setCargo(request.getParameter("cargo"));
        dto.getEntidad().setUnidadAcademica(request.getParameter("unidadAcademica"));
        dto.getEntidad().setEspecialidad(Integer.parseInt(request.getParameter("especialidad")));
        dto.getEntidad().setTipoUsuario(request.getParameter("tipoUsuario"));
        dto.getEntidad().setEmail(request.getParameter("email"));
        dto.getEntidad().setClave(request.getParameter("clave"));

        try {
            dao.create(dto);
            
            //******************ENVIO DE CORREO*********************************
            String nombre = dto.getEntidad().getNombre();
            String paterno = dto.getEntidad().getPaterno();
            String materno = dto.getEntidad().getMaterno();
            String password = dto.getEntidad().getClave();
            String tipoU = dto.getEntidad().getTipoUsuario();
            String correo = dto.getEntidad().getEmail();
            String tipoE = "";
            if ("M".equals(tipoU)) {
                tipoE = "Doctor(a): ";
            }
            if ("E".equals(tipoU)) {
                tipoE = "Enfermero(a): ";
            }
            String correonuevo = dto.getEntidad().getEmail();
            EnviarMail email = new EnviarMail();
            String asunto = "Bienvenido(a) al sistema";
            String texto = "Estimado " + tipoE + nombre + " " + paterno + " " + materno + ", acaba de registrarse en el sistema.\n"
                    + "Ahora podrá hacer uso de la cuenta con los siguientes datos:\n\n"
                    + "\tUsuario: " + correonuevo
                    + "\n\tContraseña: " + password
                    + "\n\n\t\tAtt: Departamento de TI.";
            email.enviarCorreo(correo, asunto, texto);
            //******************************************************************

            RequestDispatcher rd = request.getRequestDispatcher("confirmacionDeRegistro.jsp");
            request.setAttribute("personalMedico", dto);
            rd.forward(request, response);
            response.sendRedirect("PersonalMedicoExternoServlet?accion=confirmacion");
        } catch (ServletException | IOException | SQLException ex) {
            Logger.getLogger(PersonalMedicoExternoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void confirmacion(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd = request.getRequestDispatcher("confirmacionDeRegistro.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(PersonalMedicoExternoServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

}
