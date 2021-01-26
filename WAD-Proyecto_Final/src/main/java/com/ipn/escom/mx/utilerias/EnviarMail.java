package com.ipn.escom.mx.utilerias;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author Cristopher Salas
 */
public class EnviarMail {
    
    public void enviarCorreo(String destinatario, String asunto, String mensaje){
        try {
        //Propiedades de la Conexion
        Properties p = new Properties();
        p.setProperty("mail.smtp.host","smtp.gmail.com");
        p.setProperty("mail.smtp.starttls.enable", "true");
        p.setProperty("mail.smtp.port", "587");
        p.setProperty("mail.smtp.user", "crisjss0112.exp@gmail.com");//Correo del que se enviarán los mensajes
        p.setProperty("mail.smtp.auth", "true");
        //Efectuar configuracion en Google para inicios de sesión poco seguros
        //https://myaccount.google.com/lesssecureapps
        
        //Crea la sesion
        Session session = Session.getDefaultInstance(p);
        //Trabajar con el mensaje
        MimeMessage elMensaje  = new MimeMessage(session);
        elMensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
        
        elMensaje.setSubject(asunto);
        elMensaje.setText(mensaje);
        Transport t = session.getTransport("smtp");
        t.connect(p.getProperty("mail.smtp.user"),"Correo99Experimental#");//Contraseña del correo
        t.sendMessage(elMensaje, elMensaje.getAllRecipients());
        
        } catch (AddressException ex) {
            Logger.getLogger(EnviarMail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EnviarMail.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void main(String[] args){
        EnviarMail email = new EnviarMail();
        String destinatario = "cristopher.salas06@gmail.com";
        String asunto = "Correo de prueba";
        String texto = "Prueba efectuada con éxito";
        
        email.enviarCorreo(destinatario, asunto, texto);
    }
}

