package com.ipn.escom.mx.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Table(name = "PersonalMedico", schema = "public")
public class PersonalMedico implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "nombreDeUsuario") Se colocan las anotaciones por si os nobres de tablas no coinciden
    private String nombre;
    private String paterno;
    private String materno;
    private String cedula;
    private String cargo;
    private String unidadAcademica;
    private int especialidad;
    private String tipoUsuario;//Indicar que es M o E

    private String email;
    private String clave;
}