package com.Softcaribean.Veterinaria.facade;

import com.Softcaribean.Veterinaria.database.Managerconexion;
import com.Softcaribean.Veterinaria.dto.RafCiudadDto;
import com.Softcaribean.Veterinaria.exception.FacException;
import com.Softcaribean.Veterinaria.mgr.RafCiudadMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RafCiudadFacImp implements RafCiudadFac{

    @Autowired
    private RafCiudadMgr rafCiudadMgr;

    public void save(RafCiudadDto rafCiudadDto) throws FacException {
        try {
            Managerconexion.getInstance().open();
            rafCiudadMgr.save(rafCiudadDto);
            Managerconexion.getInstance().commit();
        } catch (Exception ex) {
            Managerconexion.getInstance().rollback();
            throw new FacException(ex);
        } finally {
            Managerconexion.getInstance().close();
        }
    }
    public List<RafCiudadDto> getall() throws FacException {
        Managerconexion.getInstance().open();
        try {

            return rafCiudadMgr.getall();

        } catch (Exception ex) {

            throw new FacException(ex);
        } finally {
            Managerconexion.getInstance().close();
        }
    }
}
