package com.Softcaribean.Veterinaria.dao;

import com.Softcaribean.Veterinaria.dto.RafCiudadDto;
import com.Softcaribean.Veterinaria.exception.DaoException;

import java.util.List;

public interface RafCiudadDao {

    public List<RafCiudadDto>getall()throws DaoException;

}
