package com.Softcaribean.Veterinaria.mgr;

import com.Softcaribean.Veterinaria.dto.RafDuenoDto;
import com.Softcaribean.Veterinaria.dto.RafPacienteDto;
import com.Softcaribean.Veterinaria.exception.MgrException;

import java.util.List;

public interface RafDuenoMgr {

    public void save(RafDuenoDto rafDuenoDto) throws MgrException;
    public List<RafDuenoDto> getall() throws MgrException;
}
