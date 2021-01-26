package com.ipn.escom.mx.modelo.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.ipn.escom.mx.modelo.entidades.Especialidad;

/**
 * @author Cristopher Salas
 */
@Data
@AllArgsConstructor
public class EspecialidadDTO implements Serializable{
    private Especialidad entidad;
    
    public EspecialidadDTO(){
        entidad = new Especialidad();
    }
}