package com.ipn.escom.mx.controlador.web;

import com.ipn.escom.mx.modelo.dao.ExpedienteDAO;
import com.ipn.escom.mx.modelo.dto.ExpedienteDTO;
import com.ipn.escom.mx.modelo.entidades.Expediente;
import com.ipn.escom.mx.utilerias.EnviarMail;
import com.ipn.escom.mx.modelo.dao.GraficaDAO;
import com.ipn.escom.mx.modelo.dao.IngresoDAO;
import com.ipn.escom.mx.modelo.dto.GraficaDTO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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

/**
 * @author Cristopher Salas
 */
@WebServlet(name = "ExpedienteServlet", urlPatterns = {"/ExpedienteServlet"})
public class ExpedienteServlet extends HttpServlet {

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

        if (accion.equals("listaDeExpedientes")) {
            listaDeExpedientes(request, response);
        } else {
            if (accion.equals("nuevo")) {
                agregarExpediente(request, response);
            } else {
                if (accion.equals("eliminar")) {
                    eliminarExpediente(request, response);
                } else {
                    if (accion.equals("actualizar")) {
                        actualizarExpediente(request, response);
                    } else {
                        if (accion.equals("guardar")) {
                            almacenarExpediente(request, response);
                        } else {
                            if (accion.equals("ver")) {
                                mostrarExpediente(request, response);
                            } else {
                                if (accion.equals("graficar")) {
                                    graficar(request, response);
                                } else {
                                    if (accion.equals("verPDF")) {
                                        //verPDF(request, response);
                                    } else {
                                        if (accion.equals("nuevaActualizacion")) {
                                            nuevaActualizacion(request, response);
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

    private void listaDeExpedientes(HttpServletRequest request, HttpServletResponse response) {
        ExpedienteDAO dao = new ExpedienteDAO();

        try {
            List lista = dao.readAll();
            request.setAttribute("listaDeIngresos", lista);
            RequestDispatcher vista = request.getRequestDispatcher("Ingresos.jsp");//Recurso jsp
            vista.forward(request, response);//le pasa al recurso el request y el response, es decir le pasa la lista con el conjunto de resultados del metodo readAll()
        } catch (ServletException | IOException | SQLException ex) {
            Logger.getLogger(ExpedienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agregarExpediente(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd = request.getRequestDispatcher("nuevoIngreso.jsp");//solo busca el recurso y lo muestra
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ExpedienteServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void eliminarExpediente(HttpServletRequest request, HttpServletResponse response) {
        ExpedienteDAO dao = new ExpedienteDAO();
        ExpedienteDTO dto = new ExpedienteDTO();
        dto.getEntidad().setIdExpediente(Integer.parseInt(request.getParameter("id")));

        try {
            dto = dao.read(dto);

            //******************ENVIO DE CORREO*********************************
            HttpSession session = (HttpSession) request.getSession();
            String correo = (String) session.getAttribute("usuarioLogueado");
            //******************************************************************
            int id = dto.getEntidad().getIdExpediente();
            EnviarMail email = new EnviarMail();
            String asunto = "Cambios en el sistema";
            String texto = "Hola, acabas de eliminar una categoría del sistema.\n"
                    + "La categoría con los siguientes datos fue eliminada:\n\n"
                    + "\tID: " + id
                    + "\n\n\t\tAtt: Departamento de TI.";
            email.enviarCorreo(correo, asunto, texto);
            //******************************************************************
            dao.delete(dto);

            response.sendRedirect("CategoriaServlet?accion=listaDeCategorias");
        } catch (IOException ex) {
            Logger.getLogger(IngresoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ExpedienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void nuevaActualizacion(HttpServletRequest request, HttpServletResponse response) {
        ExpedienteDAO dao = new ExpedienteDAO();
        ExpedienteDTO dto = new ExpedienteDTO();
        dto.getEntidad().setIdExpediente(Integer.parseInt(request.getParameter("id")));
        RequestDispatcher rd = request.getRequestDispatcher("actualizarIngreso.jsp");

        try {
            dto = dao.read(dto);
            request.setAttribute("expediente", dto);
            rd.forward(request, response);
        } catch (ServletException | IOException | SQLException ex) {
            Logger.getLogger(ExpedienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void actualizarExpediente(HttpServletRequest request, HttpServletResponse response) {
        ExpedienteDAO dao = new ExpedienteDAO();
        ExpedienteDTO dto = new ExpedienteDTO();

        dto.getEntidad().setIdExpediente(Integer.parseInt(request.getParameter("idExpediente")));

        try {
            dao.update(dto);

            //******************ENVIO DE CORREO*********************************
            HttpSession session = (HttpSession) request.getSession();
            String correo = (String) session.getAttribute("usuarioLogueado");
            //******************************************************************
            int id = dto.getEntidad().getIdExpediente();
            //String nombre = dto.getEntidad().getNombreCategoria();
            //String descripcion = dto.getEntidad().getDescripcionCategoria();
            EnviarMail email = new EnviarMail();
            String asunto = "Cambios en el sistema";
            String texto = "Hola, acabas de efectuar una modificación en el sistema.\n"
                    + "Una categoría fue modificada de la siguiente forma:\n\n"
                    + "\tID: " + id
                    //+ "\n\tNombre: " + nombre
                    //+ "\n\tDescripción: " + descripcion
                    + "\n\n\t\tAtt: Departamento de TI.";
            email.enviarCorreo(correo, asunto, texto);
            //******************************************************************
            listaDeExpedientes(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ExpedienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void almacenarExpediente(HttpServletRequest request, HttpServletResponse response) {
        ExpedienteDTO dto = new ExpedienteDTO();
        ExpedienteDAO dao = new ExpedienteDAO();
        String id = request.getParameter("idExpediente");

        dto.getEntidad().setIdExpediente(Integer.parseInt(id));

        try {
            dao.create(dto);

            //******************ENVIO DE CORREO*********************************
            HttpSession session = (HttpSession) request.getSession();
            String correo = (String) session.getAttribute("usuarioLogueado");
            //******************************************************************
            int iden = dto.getEntidad().getIdExpediente();
            //String nombre = dto.getEntidad().getNombreCategoria();
            //String descripcion = dto.getEntidad().getDescripcionCategoria();
            EnviarMail email = new EnviarMail();
            String asunto = "Cambios en el sistema";
            String texto = "Hola, acabas de crear una nueva categoría en el sistema.\n"
                    + "Ahora podrás hacer uso de ella en el registro de los productos:\n\n"
                    + "\tID: " + iden
                    //+ "\n\tNombre: " + nombre
                    //+ "\n\tDescripción: " + descripcion
                    + "\n\n\t\tAtt: Departamento de TI.";
            email.enviarCorreo(correo, asunto, texto);
            //******************************************************************
            listaDeExpedientes(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ExpedienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void mostrarExpediente(HttpServletRequest request, HttpServletResponse response) {
        ExpedienteDAO dao = new ExpedienteDAO();
        ExpedienteDTO dto = new ExpedienteDTO();
        dto.getEntidad().setIdExpediente(Integer.parseInt(request.getParameter("idExpediente")));
        RequestDispatcher rd = request.getRequestDispatcher("verExpediente.jsp");

        try {
            dto = dao.read(dto);
            request.setAttribute("expediente", dto);
            rd.forward(request, response);
        } catch (ServletException | IOException | SQLException ex) {
            Logger.getLogger(ExpedienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void graficar(HttpServletRequest request, HttpServletResponse response) {
        JFreeChart grafica = ChartFactory.createPieChart3D("Productos por Categoría",
                getGraficaProductos(), true, true, Locale.ITALY);
        //i10N i l101N
        String archivo = getServletConfig().getServletContext().getRealPath("/grafica.png");
        try {
            ChartUtils.saveChartAsPNG(new File(archivo), grafica, 500, 500);
            RequestDispatcher rd = request.getRequestDispatcher("graficasCategoria.jsp");
            rd.forward(request, response);
        } catch (IOException | ServletException ex) {
            Logger.getLogger(ExpedienteServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            Logger.getLogger(IngresoServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return pie3d;
    }

    private void verPDF(HttpServletRequest request, HttpServletResponse response) {
        IngresoDAO dao = new IngresoDAO();
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
}
