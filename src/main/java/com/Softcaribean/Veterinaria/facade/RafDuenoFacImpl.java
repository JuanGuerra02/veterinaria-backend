package com.Softcaribean.Veterinaria.facade;

import com.Softcaribean.Veterinaria.database.Managerconexion;
import com.Softcaribean.Veterinaria.dto.RafDuenoDto;
import com.Softcaribean.Veterinaria.dto.RafPacienteDto;
import com.Softcaribean.Veterinaria.exception.FacException;
import com.Softcaribean.Veterinaria.mgr.RafDuenoMgr;
import com.Softcaribean.Veterinaria.mgr.RafPacienteMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RafDuenoFacImpl  implements RafDuenoFac{

    @Autowired
    private RafDuenoMgr rafDuenoMgr;

    public void save(RafDuenoDto rafDuenoDto) throws FacException {
        try {
            Managerconexion.getInstance().open();
            rafDuenoMgr.save(rafDuenoDto);
            Managerconexion.getInstance().commit();
        } catch (Exception ex) {
            Managerconexion.getInstance().rollback();
            throw new FacException(ex);
        } finally {
            Managerconexion.getInstance().close();
        }
    }

    public List<RafDuenoDto> getall() throws FacException {
        Managerconexion.getInstance().open();
        try {

            return rafDuenoMgr.getall();

        } catch (Exception ex) {

            throw new FacException(ex);
        } finally {
            Managerconexion.getInstance().close();
        }
    }

}
