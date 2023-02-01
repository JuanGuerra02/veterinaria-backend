package com.Softcaribean.Veterinaria.facade;

import com.Softcaribean.Veterinaria.exception.FacException;
import com.Softcaribean.Veterinaria.dto.RafCiudadDto;

import java.util.List;

public interface RafCiudadFac {

    public List<RafCiudadDto> getall() throws FacException;

}
