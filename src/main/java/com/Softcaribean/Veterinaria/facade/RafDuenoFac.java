package com.Softcaribean.Veterinaria.facade;

import com.Softcaribean.Veterinaria.dto.RafDuenoDto;
import com.Softcaribean.Veterinaria.dto.RafPacienteDto;
import com.Softcaribean.Veterinaria.exception.FacException;

import java.util.List;

public interface RafDuenoFac {

    public void save(RafDuenoDto rafDuenoDto) throws FacException;
    public List<RafDuenoDto> getall() throws FacException;
}
