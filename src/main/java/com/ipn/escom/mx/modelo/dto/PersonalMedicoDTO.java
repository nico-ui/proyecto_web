package com.ipn.escom.mx.modelo.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.ipn.escom.mx.modelo.entidades.PersonalMedico;

/**
 * @author Cristopher Salas
 */
@Data
@AllArgsConstructor
public class PersonalMedicoDTO implements Serializable{
    private PersonalMedico entidad;
    
    public PersonalMedicoDTO(){
        entidad = new PersonalMedico();
    }
}