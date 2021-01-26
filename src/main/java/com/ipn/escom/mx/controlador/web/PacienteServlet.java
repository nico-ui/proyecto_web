package com.ipn.escom.mx.controlador.web;

import com.ipn.escom.mx.utilerias.EnviarMail;
import com.ipn.escom.mx.modelo.dao.GraficaDAO;
import com.ipn.escom.mx.modelo.dto.GraficaDTO;
import com.ipn.escom.mx.modelo.dao.PacienteDAO;
import com.ipn.escom.mx.modelo.dto.PacienteDTO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;//
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

//librerias apache que se emplearon para reducir la complejidad de la subida de archivos
//import org.apache.commons.fileupload.FileItem;//se manejan pedazos que representa esta clase
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;//clase que permite el manejo de los pedazos
//import org.apache.commons.fileupload.servlet.ServletFileUpload;//subida de archivo
/**
 * @author Cristopher Salas
 */
@WebServlet(name = "PacienteServlet", urlPatterns = {"/PacienteServlet"})
public class PacienteServlet extends HttpServlet {

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

        //**********Atributo subido en sesion***********************************
        HttpSession session = (HttpSession) request.getSession();
        String nombre = (String) session.getAttribute("usuarioLogueado");
        String id = (String) session.getAttribute("idLogueado");
        //**********************************************************************

        String accion = request.getParameter("accion");

        if (accion.equals("listaDePacientes")) {
            listaDePacientes(request, response);
        } else {
            if (accion.equals("nuevo")) {
                agregarPaciente(request, response);
            } else {
                if (accion.equals("eliminar")) {
                    eliminarPaciente(request, response);
                } else {
                    if (accion.equals("actualizar")) {
                        actualizarPaciente(request, response);
                    } else {
                        if (accion.equals("guardar")) {
                            almacenarPaciente(request, response);
                        } else {
                            if (accion.equals("ver")) {
                                mostrarPaciente(request, response);
                            } else {
                                if (accion.equals("graficar")) {
                                    graficar(request, response);
                                } else {
                                    if (accion.equals("verPDF")) {
                                        verPDF(request, response);
                                    } else {
                                        if (accion.equals("nuevaActualizacion")) {
                                            nuevaActualizacion(request, response);
                                        } else {
                                            if (accion.equals("eliminarDefinitivoP")) {
                                                eliminarDP(request, response);
                                            } else {
                                                if (accion.equals("eliminarDefinitivoA")) {
                                                    eiminarDA(request, response);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
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

    private void listaDePacientes(HttpServletRequest request, HttpServletResponse response) {
        PacienteDAO dao = new PacienteDAO();

        try {
            List lista = dao.readAll();
            request.setAttribute("listaDePacientes", lista);
            RequestDispatcher vista = request.getRequestDispatcher("pacientes.jsp");
            vista.forward(request, response);
        } catch (ServletException | IOException | SQLException ex) {
            Logger.getLogger(PacienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agregarPaciente(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd = request.getRequestDispatcher("nuevoPaciente.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(PacienteServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void eliminarPaciente(HttpServletRequest request, HttpServletResponse response) {
        PacienteDAO dao = new PacienteDAO();
        PacienteDTO dto = new PacienteDTO();
        dto.getEntidad().setNss(Integer.parseInt(request.getParameter("nss")));

        try {
            dto = dao.read(dto);
            //******************ENVIO DE CORREO*********************************
            HttpSession session = (HttpSession) request.getSession();
            String correo = (String) session.getAttribute("usuarioLogueado");
            //******************************************************************
            int id = dto.getEntidad().getNss();
            String nombre = dto.getEntidad().getNombre();
            String paterno = dto.getEntidad().getPaterno();
            String materno = dto.getEntidad().getMaterno();
            EnviarMail email = new EnviarMail();
            String asunto = "Cambios en el sistema";
            String texto = "Hola, acabas de eliminar a un usuario del sistema.\n"
                    + "El usuario con los siguientes datos fue eliminado(a):\n\n"
                    + "\tID: " + id
                    + "\n\tNombre: " + nombre
                    + "\n\tAp. paterno: " + paterno
                    + "\n\tAp. materno: " + materno
                    + "\n\n\t\tAtt: Departamento de TI.";
            email.enviarCorreo(correo, asunto, texto);
            //******************************************************************
            dao.delete(dto);
            response.sendRedirect("PacienteServlet?accion=listaDePacientes");;
        } catch (IOException | SQLException ex) {
            Logger.getLogger(PacienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void actualizarPaciente(HttpServletRequest request, HttpServletResponse response) {
        PacienteDAO dao = new PacienteDAO();
        PacienteDTO dto = new PacienteDTO();
        
        dto.getEntidad().setNss(Integer.parseInt(request.getParameter("nss")));
        dto.getEntidad().setNombre(request.getParameter("nombre"));
        dto.getEntidad().setPaterno(request.getParameter("paterno"));
        dto.getEntidad().setMaterno(request.getParameter("materno"));
        dto.getEntidad().setTelefono(request.getParameter("telefono"));
        dto.getEntidad().setEmail(request.getParameter("email"));
        dto.getEntidad().setFechaNacimiento(request.getParameter("fechaNacimiento"));
        dto.getEntidad().setSexo(request.getParameter("sexo"));
        dto.getEntidad().setIdExpediente(Integer.parseInt(request.getParameter("idExpediente")));

        try {
            dao.update(dto);

            //******************ENVIO DE CORREO*********************************
            HttpSession session = (HttpSession) request.getSession();
            String correo = (String) session.getAttribute("usuarioLogueado");
            //******************************************************************
            int id = dto.getEntidad().getNss();
            String nombre = dto.getEntidad().getNombre();
            String paterno = dto.getEntidad().getPaterno();
            String materno = dto.getEntidad().getMaterno();
            EnviarMail email = new EnviarMail();
            String asunto = "Cambios en el sistema";
            String texto = "Hola, acabas de efectuar una modificación en el sistema.\n"
                    + "Un paciente fue modificado de la siguiente forma:\n\n"
                    + "\tNSS: " + id
                    + "\n\tNombre: " + nombre
                    + "\n\tAp. paterno: " + paterno
                    + "\n\tAp. materno: " + materno
                    + "\n\n\t\tAtt: Departamento de TI.";
            email.enviarCorreo(correo, asunto, texto);
            //******************************************************************

            response.sendRedirect("PacienteServlet?accion=listaDePacientes");
        } catch (IOException | SQLException ex) {
            Logger.getLogger(PacienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void almacenarPaciente(HttpServletRequest request, HttpServletResponse response) {
        PacienteDTO dto = new PacienteDTO();
        PacienteDAO dao = new PacienteDAO();
        String id = request.getParameter("nss");

        dto.getEntidad().setNss(Integer.parseInt(id));
        dto.getEntidad().setNombre(request.getParameter("nombre"));
        dto.getEntidad().setPaterno(request.getParameter("paterno"));
        dto.getEntidad().setMaterno(request.getParameter("materno"));
        dto.getEntidad().setEmail(request.getParameter("email"));

        try {
            dao.create(dto);

            //******************ENVIO DE CORREO*********************************
            HttpSession session = (HttpSession) request.getSession();
            String correo = (String) session.getAttribute("usuarioLogueado");
            //******************************************************************
            String nombre = dto.getEntidad().getNombre();
            String correonuevo = dto.getEntidad().getEmail();
            EnviarMail email = new EnviarMail();
            String asunto = "Bienvenido(a) al sistema";
            String texto = "Hola " + nombre + ", acabas de registrarte en el sistema.\n"
                    + "Ahora podrás hacer uso de la cuenta con los siguientes datos:\n\n"
                    + "\tUsuario: " + correonuevo
                    + "\n\n\t\tAtt: Departamento de TI.";
            email.enviarCorreo(correo, asunto, texto);
            //******************************************************************

            response.sendRedirect("PacienteServlet?accion=listaDePacientes");
        } catch (IOException | SQLException ex) {
            Logger.getLogger(PacienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void mostrarPaciente(HttpServletRequest request, HttpServletResponse response) {
        PacienteDAO dao = new PacienteDAO();
        PacienteDTO dto = new PacienteDTO();
        dto.getEntidad().setNss(Integer.parseInt(request.getParameter("nss")));
        RequestDispatcher rd = request.getRequestDispatcher("verPaciente.jsp");

        try {
            dto = dao.read(dto);
            request.setAttribute("paciente", dto);
            rd.forward(request, response);
        } catch (ServletException | IOException | SQLException ex) {
            Logger.getLogger(PacienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void graficar(HttpServletRequest request, HttpServletResponse response) {
        JFreeChart grafica = ChartFactory.createPieChart3D("Productos por Categoría",
                getGraficaProductos(), true, true, Locale.ITALY);
        //i10N i l101N
        String archivo = getServletConfig().getServletContext().getRealPath("/grafica.png");
        try {
            ChartUtils.saveChartAsPNG(new File(archivo), grafica, 500, 500);
            RequestDispatcher rd = request.getRequestDispatcher("grafica.jsp");
            rd.forward(request, response);
        } catch (IOException | ServletException ex) {
            Logger.getLogger(PacienteServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //<img src="grafica.png"/>
    }

    private PieDataset getGraficaProductos() {
        DefaultPieDataset pie3d = new DefaultPieDataset();
        GraficaDAO gDAO = new GraficaDAO();

        try {
            List datos = gDAO.grafica();
            for (int i = 0; i < datos.size(); i++) {
                GraficaDTO dto = (GraficaDTO) datos.get(i);
                pie3d.setValue(dto.getNombre(), dto.getCantidad());
            }
        } catch (SQLException ex) {
            Logger.getLogger(PacienteServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return pie3d;
    }

    private void verPDF(HttpServletRequest request, HttpServletResponse response) {
        PacienteDAO dao = new PacienteDAO();
        try {
            ServletOutputStream sos = response.getOutputStream();
            File reporte = new File(getServletConfig().getServletContext().getRealPath("/reportes/ListaDeUsuarios.jasper"));
            byte[] bytes = JasperRunManager.runReportToPdf(reporte.getPath(), null, dao.obtenerConexion());//para quitar el error se hizo obtenerConexicon() publico en CategoriaDAO
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);

            sos.write(bytes, 0, bytes.length);
            sos.flush();
            sos.close();
        } catch (IOException | JRException ex) {
            Logger.getLogger(PacienteServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void nuevaActualizacion(HttpServletRequest request, HttpServletResponse response) {
        PacienteDAO dao = new PacienteDAO();
        PacienteDTO dto = new PacienteDTO();
        dto.getEntidad().setNss(Integer.parseInt(request.getParameter("nss")));
        RequestDispatcher rd = request.getRequestDispatcher("actualizarPaciente.jsp");

        try {
            dto = dao.read(dto);
            request.setAttribute("paciente", dto);
            rd.forward(request, response);
        } catch (ServletException | IOException | SQLException ex) {
            Logger.getLogger(PacienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void eliminarDP(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd = request.getRequestDispatcher("confirmarEliminacionDefinitiva.jsp");
        PacienteDAO dao = new PacienteDAO();
        PacienteDTO dto = new PacienteDTO();
        dto.getEntidad().setNss(Integer.parseInt(request.getParameter("nss")));

        try {
            dto = dao.read(dto);
            request.setAttribute("paciente", dto);
            rd.forward(request, response);
        } catch (ServletException | IOException | SQLException ex) {
            Logger.getLogger(PacienteServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void eiminarDA(HttpServletRequest request, HttpServletResponse response) {
        PacienteDAO dao = new PacienteDAO();
        PacienteDTO dto = new PacienteDTO();
        dto.getEntidad().setNss(Integer.parseInt(request.getParameter("nss")));

        try {
            dto = dao.read(dto);
            //******************ENVIO DE CORREO*********************************
            HttpSession session = (HttpSession) request.getSession();
            String correo = (String) session.getAttribute("usuarioLogueado");
            //******************************************************************
            int id = dto.getEntidad().getNss();
            String nombre = dto.getEntidad().getNombre();
            String paterno = dto.getEntidad().getPaterno();
            String materno = dto.getEntidad().getMaterno();
            EnviarMail email = new EnviarMail();
            String asunto = "Cuenta eliminada";
            String texto = "Hola, acabas de eliminar tu cuenta.\n"
                    + "El usuario con los siguientes datos fue eliminado(a) del sistema de forma permanente:\n\n"
                    + "\tID: " + id
                    + "\n\tNombre: " + nombre
                    + "\n\tAp. paterno: " + paterno
                    + "\n\tAp. materno: " + materno
                    + "\n\n\t\tAtt: Departamento de TI.";
            email.enviarCorreo(correo, asunto, texto);
            //******************************************************************
            dao.delete(dto);
            response.sendRedirect("LoginServlet?accion=logout");;
        } 
        catch (IOException | SQLException ex) {
            Logger.getLogger(PacienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}