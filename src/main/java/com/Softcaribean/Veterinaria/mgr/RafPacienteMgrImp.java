package com.Softcaribean.Veterinaria.mgr;

import com.Softcaribean.Veterinaria.dao.RafPacienteDao;
import com.Softcaribean.Veterinaria.dto.RafPacienteDto;
import com.Softcaribean.Veterinaria.exception.MgrException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RafPacienteMgrImp implements RafPacienteMgr{

    @Autowired
    private RafPacienteDao rafPacienteDao;

    public void save(RafPacienteDto rafPacienteDto) throws MgrException {
        try {
            RafPacienteDto x = rafPacienteDao.selectbyid(rafPacienteDto);
            if (x == null) {
                rafPacienteDao.insert(rafPacienteDto);
            }else{
                rafPacienteDao.update(rafPacienteDto);
            }
        } catch (Exception ex) {
            throw new MgrException(ex);
        }
    }
    /*
    public void delete(RafPacienteDto rafPacienteDto) throws MgrException {
        try {
            RafPacienteDto x = rafPacienteDao.selectbyid(rafPacienteDto);
            if (x != null) {
                rafPacienteDao.delete(rafPacienteDto);
            }
        } catch (Exception ex) {
            throw new MgrException(ex);
        }
    }
    */

    public List<RafPacienteDto> getall() throws MgrException {
        try {
            return rafPacienteDao.getall();
        } catch (Exception ex) {
            throw new MgrException(ex);
        }
    }
}
