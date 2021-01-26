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
@Table(name = "Especialidad", schema = "public")
public class Especialidad implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "nombreDeUsuario") Se colocan las anotaciones por si os nobres de tablas no coinciden
    private int idEspecialidad;
    private String nombre;
}
