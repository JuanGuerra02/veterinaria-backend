package com.Softcaribean.Veterinaria.dao;

import com.Softcaribean.Veterinaria.dto.RafCiudadDto;
import com.Softcaribean.Veterinaria.exception.DaoException;

import java.util.List;

public interface RafCiudadDao {

    public void insert(RafCiudadDto rafCiudadDto) throws DaoException;
    public void update(RafCiudadDto rafCiudadDto) throws DaoException;
    public RafCiudadDto selectbyid(RafCiudadDto rafCiudadDto) throws DaoException;
    public List<RafCiudadDto>getall()throws DaoException;

}
