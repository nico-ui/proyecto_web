package com.ipn.escom.mx.modelo.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.ipn.escom.mx.modelo.entidades.Paciente;

/**
 * @author Cristopher Salas
 */
@Data
@AllArgsConstructor
public class PacienteDTO implements Serializable{
    private Paciente entidad;
    
    public PacienteDTO(){
        entidad = new Paciente();
    }
}