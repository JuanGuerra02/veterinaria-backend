package com.Softcaribean.Veterinaria.dao;

import com.Softcaribean.Veterinaria.dto.RafPacienteDto;
import com.Softcaribean.Veterinaria.exception.DaoException;

import java.util.List;

public interface RafPacienteDao {

    public void insert(RafPacienteDto rafPacienteDto) throws DaoException;
    public void update(RafPacienteDto rafPacienteDto) throws DaoException;
    public RafPacienteDto selectbyid(RafPacienteDto rafPacienteDto) throws DaoException;
    public List<RafPacienteDto> getall()throws DaoException;

}
