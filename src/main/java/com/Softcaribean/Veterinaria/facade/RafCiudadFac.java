package com.Softcaribean.Veterinaria.facade;

import com.Softcaribean.Veterinaria.exception.FacException;
import com.Softcaribean.Veterinaria.dto.RafCiudadDto;

import java.util.List;

public interface RafCiudadFac {

    public void save(RafCiudadDto rafCiudadDto) throws FacException;
    public void delete(RafCiudadDto rafCiudadDto) throws FacException;
    public List<RafCiudadDto> getall() throws FacException;

}
