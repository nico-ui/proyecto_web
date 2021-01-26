package com.ipn.escom.mx.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Cristopher Salas
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Paciente", schema = "public")
public class Paciente implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nss;
    //@Column(name = "nombreDeUsuario") Se colocan las anotaciones por si os nobres de tablas no coinciden
    private String nombre;
    private String paterno;
    private String materno;
    private String telefono;
    private String email;
    @Temporal(javax.persistence.TemporalType.DATE)
    private String fechaNacimiento;
    private String sexo;
    
    private int idExpediente;
}
