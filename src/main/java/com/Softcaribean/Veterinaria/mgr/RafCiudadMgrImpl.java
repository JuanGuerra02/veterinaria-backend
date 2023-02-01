package com.Softcaribean.Veterinaria.mgr;

import com.Softcaribean.Veterinaria.dao.RafCiudadDao;
import com.Softcaribean.Veterinaria.exception.MgrException;
import com.Softcaribean.Veterinaria.dto.RafCiudadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RafCiudadMgrImpl implements RafCiudadMgr {

    @Autowired
    private RafCiudadDao rafCiudadDao;

    public void save(RafCiudadDto rafCiudadDto) throws MgrException {
        try {
            RafCiudadDto x = rafCiudadDao.selectbyid(rafCiudadDto);
            if (x == null) {
                rafCiudadDao.insert(rafCiudadDto);
            }else{
                rafCiudadDao.update(rafCiudadDto);
            }
        } catch (Exception ex) {
            throw new MgrException(ex);
        }
    }
    public void delete(RafCiudadDto rafCiudadDto) throws MgrException {
        try {
            RafCiudadDto x = rafCiudadDao.selectbyid(rafCiudadDto);
            if (x != null) {
                rafCiudadDao.delete(rafCiudadDto);
            }
        } catch (Exception ex) {
            throw new MgrException(ex);
        }
    }
    public List<RafCiudadDto> getall() throws MgrException {
        try {
            return rafCiudadDao.getall();
        } catch (Exception ex) {
            throw new MgrException(ex);
        }
    }
}
