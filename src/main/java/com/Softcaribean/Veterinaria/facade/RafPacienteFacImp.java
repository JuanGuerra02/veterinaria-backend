package com.Softcaribean.Veterinaria.facade;

import com.Softcaribean.Veterinaria.database.Managerconexion;
import com.Softcaribean.Veterinaria.dto.RafPacienteDto;
import com.Softcaribean.Veterinaria.exception.FacException;
import com.Softcaribean.Veterinaria.mgr.RafPacienteMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RafPacienteFacImp implements  RafPacienteFac{

    @Autowired
    private RafPacienteMgr rafPacienteMgr;

    public void save(RafPacienteDto rafPacienteDto) throws FacException {
        try {
            Managerconexion.getInstance().open();
            rafPacienteMgr.save(rafPacienteDto);
            Managerconexion.getInstance().commit();
        } catch (Exception ex) {
            Managerconexion.getInstance().rollback();
            throw new FacException(ex);
        } finally {
            Managerconexion.getInstance().close();
        }
    }

    /*
    public void delete(RafPacienteDto rafPacienteDto) throws FacException {
        try {
            Managerconexion.getInstance().open();
            rafPacienteMgr.delete(rafPacienteDto);
            Managerconexion.getInstance().commit();
        } catch (Exception ex) {
            Managerconexion.getInstance().rollback();
            throw new FacException(ex);
        } finally {
            Managerconexion.getInstance().close();
        }
    }
     */

    public List<RafPacienteDto> getall() throws FacException {
        Managerconexion.getInstance().open();
        try {

            return rafPacienteMgr.getall();

        } catch (Exception ex) {

            throw new FacException(ex);
        } finally {
            Managerconexion.getInstance().close();
        }
    }
}
