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
@Table(name = "Expediente", schema = "public")
public class Expediente implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "nombreDeUsuario") Se colocan las anotaciones por si os nobres de tablas no coinciden
    private int idExpediente;
    //@Temporal(javax.persistence.TemporalType.DATE)
    private String edad;
    private String sexo;
    private String tipoSanguineo;
    private String altura;
    private String peso;
    private String presionArterial;
    private String temperatura;
    private String glucosa;
    private String frecuenciaCardiaca;
    private String frecuenciaRespiratoria;
    private String medicamentos;
    private String alergias;
    private String antecedentesFamiliares;
    private String estudiosLaboratorio;
    private String padecimientoActual;
    private String padecimientosPrevios;
}