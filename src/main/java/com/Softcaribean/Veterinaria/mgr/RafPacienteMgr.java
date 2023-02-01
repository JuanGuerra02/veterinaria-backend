package com.Softcaribean.Veterinaria.mgr;

import com.Softcaribean.Veterinaria.dto.RafPacienteDto;
import com.Softcaribean.Veterinaria.exception.MgrException;

import java.util.List;

public interface RafPacienteMgr {

    public void save(RafPacienteDto rafPacienteDto) throws MgrException;

    /*public void delete(RafPacienteDto rafPacienteDto) throws MgrException;*/
    public List<RafPacienteDto> getall() throws MgrException;
}
