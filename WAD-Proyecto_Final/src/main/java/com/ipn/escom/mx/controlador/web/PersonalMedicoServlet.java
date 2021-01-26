package com.ipn.escom.mx.controlador.web;

import com.ipn.escom.mx.modelo.dao.EspecialidadDAO;
import com.ipn.escom.mx.utilerias.EnviarMail;
import com.ipn.escom.mx.modelo.dao.IngresoDAO;
import com.ipn.escom.mx.modelo.dto.IngresoDTO;
import com.ipn.escom.mx.modelo.dto.GraficaDTO;
import com.ipn.escom.mx.modelo.dao.GraficaDAO;
import com.ipn.escom.mx.modelo.dao.PersonalMedicoDAO;
import com.ipn.escom.mx.modelo.dto.PersonalMedicoDTO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
//import java.lang.System.Logger.Level;//no esta 
import java.sql.SQLException;
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
@WebServlet(name = "PersonalMedicoServlet", urlPatterns = {"/PersonalMedicoServlet"})
public class PersonalMedicoServlet extends HttpServlet {

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

        if (accion.equals("listaDeUsuarios")) {
            listaDeUsuarios(request, response);
        } else {
            if (accion.equals("nuevo")) {
                agregarPersonalMedico(request, response);
            } else {
                if (accion.equals("eliminar")) {
                    eliminarPersonalMedico(request, response);
                } else {
                    if (accion.equals("actualizar")) {
                        actualizarPersonalMedico(request, response);
                    } else {
                        if (accion.equals("guardar")) {
                            almacenarPersonalMedico(request, response);
                        } else {
                            if (accion.equals("ver")) {
                                mostrarPersonalMedico(request, response);
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
                                                } else {
                                                    if (accion.equals("elegirPersonalMedico")) {
                                                        elegirPersonalMedico(request, response);
                                                    } else {
                                                        if (accion.equals("listaDeMedicos")) {
                                                            listaDeMedicos(request, response);
                                                        } else {
                                                            if (accion.equals("listaDeEnfermeros")) {
                                                                listaDeEnfermeros(request, response);
                                                            } else {
                                                                if (accion.equals("listaE")) {
                                                                    listaDeEspecialidades(request, response);
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

    private void listaDeUsuarios(HttpServletRequest request, HttpServletResponse response) {
        PersonalMedicoDAO dao = new PersonalMedicoDAO();

        try {
            List lista = dao.readAll();
            request.setAttribute("listaDeUsuarios", lista);
            RequestDispatcher vista = request.getRequestDispatcher("personalMedico.jsp");
            vista.forward(request, response);
        } catch (ServletException | IOException | SQLException ex) {
            Logger.getLogger(PersonalMedicoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void listaDeMedicos(HttpServletRequest request, HttpServletResponse response) {
        PersonalMedicoDAO dao = new PersonalMedicoDAO();

        try {
            List lista = dao.readAll();
            request.setAttribute("listaDeMedicos", lista);
            RequestDispatcher vista = request.getRequestDispatcher("medicos.jsp");
            vista.forward(request, response);
        } catch (ServletException | IOException | SQLException ex) {
            Logger.getLogger(PersonalMedicoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void listaDeEnfermeros(HttpServletRequest request, HttpServletResponse response) {
        PersonalMedicoDAO dao = new PersonalMedicoDAO();

        try {
            List lista = dao.readAll();
            request.setAttribute("listaDeEnfermeros", lista);
            RequestDispatcher vista = request.getRequestDispatcher("enfermeros.jsp");
            vista.forward(request, response);
        } catch (ServletException | IOException | SQLException ex) {
            Logger.getLogger(PersonalMedicoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void elegirPersonalMedico(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd = request.getRequestDispatcher("personalMedico.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(PersonalMedicoServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void agregarPersonalMedico(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd = request.getRequestDispatcher("nuevoPersonalMedico.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(PersonalMedicoServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void eliminarPersonalMedico(HttpServletRequest request, HttpServletResponse response) {
        PersonalMedicoDAO dao = new PersonalMedicoDAO();
        PersonalMedicoDTO dto = new PersonalMedicoDTO();
        dto.getEntidad().setEmail(request.getParameter("email"));

        try {
            dto = dao.read(dto);
            //******************ENVIO DE CORREO*********************************
            HttpSession session = (HttpSession) request.getSession();
            String correo = (String) session.getAttribute("usuarioLogueado");
            //******************************************************************
            String id = dto.getEntidad().getEmail();
            String nombre = dto.getEntidad().getNombre();
            String password = dto.getEntidad().getClave();
            String paterno = dto.getEntidad().getPaterno();
            String materno = dto.getEntidad().getMaterno();
            String tipo = dto.getEntidad().getTipoUsuario();
            EnviarMail email = new EnviarMail();
            String asunto = "Cambios en el sistema";
            String texto = "Hola, acabas de eliminar a un usuario del sistema.\n"
                    + "El usuario con los siguientes datos fue eliminado(a):\n\n"
                    + "\tID: " + id
                    + "\n\tNombre: " + nombre
                    + "\n\tAp. paterno: " + paterno
                    + "\n\tAp. materno: " + materno
                    + "\n\tContraseña: " + password
                    + "\n\tTipo de usuario: " + tipo
                    + "\n\n\t\tAtt: Departamento de TI.";
            email.enviarCorreo(correo, asunto, texto);
            //******************************************************************
            dao.delete(dto);
            response.sendRedirect("PersonalMedicoServlet?accion=elegirPersonalMedico");;
        } catch (IOException | SQLException ex) {
            Logger.getLogger(PersonalMedicoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void actualizarPersonalMedico(HttpServletRequest request, HttpServletResponse response) {
        PersonalMedicoDAO dao = new PersonalMedicoDAO();
        PersonalMedicoDTO dto = new PersonalMedicoDTO();

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
            dao.update(dto);
        } catch (SQLException ex) {
            Logger.getLogger(PersonalMedicoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        //******************ENVIO DE CORREO*********************************
        HttpSession session = (HttpSession) request.getSession();
        String correo = (String) session.getAttribute("usuarioLogueado");
        //******************************************************************
        String id = dto.getEntidad().getEmail();//Reemplazable por correo
        String nombre = dto.getEntidad().getNombre();
        String password = dto.getEntidad().getClave();
        String paterno = dto.getEntidad().getPaterno();
        String materno = dto.getEntidad().getMaterno();
        String tipo = dto.getEntidad().getTipoUsuario();
        EnviarMail email = new EnviarMail();
        String asunto = "Cambios en el sistema";
        String texto = "Hola, acabas de efectuar una modificación en el sistema.\n"
                + "El usuario fue modificado de la siguiente forma:\n\n"
                + "\tID: " + id
                + "\n\tNombre: " + nombre
                + "\n\tAp. paterno: " + paterno
                + "\n\tAp. materno: " + materno
                + "\n\tContraseña: " + password
                + "\n\tTipo de usuario: " + tipo
                + "\n\n\t\tAtt: Departamento de TI.";
        email.enviarCorreo(correo, asunto, texto);
        try {
            //******************************************************************
            response.sendRedirect("PersonalMedicoServlet?accion=elegirPersonalMedico");
        } catch (IOException ex) {
            Logger.getLogger(PersonalMedicoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void almacenarPersonalMedico(HttpServletRequest request, HttpServletResponse response) {
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
            HttpSession session = (HttpSession) request.getSession();
            String correo = (String) session.getAttribute("usuarioLogueado");
            //******************************************************************
            String nombre = dto.getEntidad().getNombre();
            String paterno = dto.getEntidad().getPaterno();
            String materno = dto.getEntidad().getMaterno();
            String password = dto.getEntidad().getClave();
            String tipoU = dto.getEntidad().getTipoUsuario();
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
            response.sendRedirect("PersonalMedicoServlet?accion=elegirPersonalMedico");
        } catch (IOException | SQLException ex) {
            Logger.getLogger(PersonalMedicoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void mostrarPersonalMedico(HttpServletRequest request, HttpServletResponse response) {
        PersonalMedicoDAO dao = new PersonalMedicoDAO();
        PersonalMedicoDTO dto = new PersonalMedicoDTO();
        dto.getEntidad().setEmail(request.getParameter("email"));
        RequestDispatcher rd = request.getRequestDispatcher("verPersonalMedico.jsp");

        try {
            dto = dao.read(dto);
            request.setAttribute("personalMedico", dto);
            rd.forward(request, response);
        } catch (ServletException | IOException | SQLException ex) {
            Logger.getLogger(PersonalMedicoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PersonalMedicoServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            Logger.getLogger(PersonalMedicoServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return pie3d;
    }

    private void verPDF(HttpServletRequest request, HttpServletResponse response) {
        PersonalMedicoDAO dao = new PersonalMedicoDAO();
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
            Logger.getLogger(PersonalMedicoServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void nuevaActualizacion(HttpServletRequest request, HttpServletResponse response) {
        PersonalMedicoDAO dao = new PersonalMedicoDAO();
        PersonalMedicoDTO dto = new PersonalMedicoDTO();
        dto.getEntidad().setEmail(request.getParameter("email"));
        RequestDispatcher rd = request.getRequestDispatcher("actualizarPersonalMedico.jsp");

        try {
            dto = dao.read(dto);
            request.setAttribute("personalMedico", dto);
            rd.forward(request, response);
        } catch (ServletException | IOException | SQLException ex) {
            Logger.getLogger(PersonalMedicoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void eliminarDP(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd = request.getRequestDispatcher("confirmarEliminacionDefinitiva.jsp");
        PersonalMedicoDAO dao = new PersonalMedicoDAO();
        PersonalMedicoDTO dto = new PersonalMedicoDTO();
        dto.getEntidad().setEmail(request.getParameter("email"));

        try {
            dto = dao.read(dto);
            request.setAttribute("personalMedico", dto);
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(PersonalMedicoServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PersonalMedicoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void eiminarDA(HttpServletRequest request, HttpServletResponse response) {
        PersonalMedicoDAO dao = new PersonalMedicoDAO();
        PersonalMedicoDTO dto = new PersonalMedicoDTO();
        dto.getEntidad().setEmail(request.getParameter("email"));

        try {
            dto = dao.read(dto);
            //******************ENVIO DE CORREO*********************************
            HttpSession session = (HttpSession) request.getSession();
            String correo = (String) session.getAttribute("usuarioLogueado");
            //******************************************************************
            String id = dto.getEntidad().getEmail();
            String nombre = dto.getEntidad().getNombre();
            String password = dto.getEntidad().getClave();
            String paterno = dto.getEntidad().getPaterno();
            String materno = dto.getEntidad().getMaterno();
            String tipo = dto.getEntidad().getTipoUsuario();
            EnviarMail email = new EnviarMail();
            String asunto = "Cuenta eliminada";
            String texto = "Hola, acabas de eliminar tu cuenta.\n"
                    + "El usuario con los siguientes datos fue eliminado(a) del sistema de forma permanente:\n\n"
                    + "\tID: " + id
                    + "\n\tNombre: " + nombre
                    + "\n\tAp. paterno: " + paterno
                    + "\n\tAp. materno: " + materno
                    + "\n\tContraseña: " + password
                    + "\n\tTipo de usuario: " + tipo
                    + "\n\n\t\tAtt: Departamento de TI.";
            email.enviarCorreo(correo, asunto, texto);
            //******************************************************************
            dao.delete(dto);
            response.sendRedirect("LoginServlet?accion=logout");;
        } catch (IOException | SQLException ex) {
            Logger.getLogger(PersonalMedicoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void listaDeEspecialidades(HttpServletRequest request, HttpServletResponse response) {
        EspecialidadDAO dao = new EspecialidadDAO();

        try {
            List lista = dao.readAll();
            request.setAttribute("listaDeEspecialidades", lista);
            RequestDispatcher vista = request.getRequestDispatcher("nuevoPersonalMedico.jsp");
            vista.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(PersonalMedicoExternoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PersonalMedicoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
