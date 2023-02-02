package com.Softcaribean.Veterinaria.dao;

import com.Softcaribean.Veterinaria.dto.RafDuenoDto;
import com.Softcaribean.Veterinaria.dto.RafPacienteDto;
import com.Softcaribean.Veterinaria.exception.DaoException;

import java.util.List;

public interface RafDuenoDao {

    public void insert(RafDuenoDto rafDuenoDto) throws DaoException;
    public void update(RafDuenoDto rafDuenoDto) throws DaoException;
    public RafDuenoDto selectbyid(RafDuenoDto rafDuenoDto) throws DaoException;
    public List<RafDuenoDto> getall()throws DaoException;
}
