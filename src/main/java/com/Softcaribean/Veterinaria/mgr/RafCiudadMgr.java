package com.Softcaribean.Veterinaria.mgr;

import com.Softcaribean.Veterinaria.exception.MgrException;
import com.Softcaribean.Veterinaria.dto.RafCiudadDto;

import java.util.List;

public interface RafCiudadMgr {

    public List<RafCiudadDto> getall() throws MgrException;
}