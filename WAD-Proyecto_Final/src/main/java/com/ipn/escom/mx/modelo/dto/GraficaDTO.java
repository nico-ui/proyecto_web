package com.ipn.escom.mx.modelo.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Cristopher Salas
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GraficaDTO implements Serializable{
    private String nombre;
    private int cantidad;
    
}