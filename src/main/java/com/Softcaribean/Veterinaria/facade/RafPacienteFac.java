package com.Softcaribean.Veterinaria.facade;

import com.Softcaribean.Veterinaria.dto.RafPacienteDto;
import com.Softcaribean.Veterinaria.exception.FacException;

import java.util.List;

public interface RafPacienteFac {

    public void save(RafPacienteDto rafPacienteDto) throws FacException;

    /*
    public void delete(RafPacienteDto rafPacienteDto) throws FacException;
     */

    public List<RafPacienteDto> getall() throws FacException;
}
