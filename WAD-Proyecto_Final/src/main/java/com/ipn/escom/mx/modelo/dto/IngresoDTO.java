package com.ipn.escom.mx.modelo.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.ipn.escom.mx.modelo.entidades.Ingreso;

/**
 * @author Cristopher Salas
 */
@Data
@AllArgsConstructor
public class IngresoDTO implements Serializable{
    private Ingreso entidad;
    
    public IngresoDTO(){
        entidad = new Ingreso();
    }
}