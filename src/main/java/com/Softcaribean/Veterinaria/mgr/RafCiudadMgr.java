package com.Softcaribean.Veterinaria.mgr;

import com.Softcaribean.Veterinaria.exception.MgrException;
import com.Softcaribean.Veterinaria.dto.RafCiudadDto;

import java.util.List;

public interface RafCiudadMgr {

    public void save(RafCiudadDto rafCiudadDto) throws MgrException;
    public void delete(RafCiudadDto rafCiudadDto) throws MgrException;
    public List<RafCiudadDto> getall() throws MgrException;
}
