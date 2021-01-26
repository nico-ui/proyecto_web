package com.ipn.escom.mx.modelo.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.ipn.escom.mx.modelo.entidades.Expediente;

/**
 * @author Cristopher Salas
 */
@Data
@AllArgsConstructor
public class ExpedienteDTO implements Serializable{
    private Expediente entidad;
    
    public ExpedienteDTO(){
        entidad = new Expediente();
    }
}