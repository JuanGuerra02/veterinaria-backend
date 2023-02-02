package com.Softcaribean.Veterinaria.mgr;

import com.Softcaribean.Veterinaria.dao.RafDuenoDao;
import com.Softcaribean.Veterinaria.dao.RafPacienteDao;
import com.Softcaribean.Veterinaria.dto.RafDuenoDto;
import com.Softcaribean.Veterinaria.dto.RafPacienteDto;
import com.Softcaribean.Veterinaria.exception.MgrException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RafDuenoMgrImpl implements  RafDuenoMgr {

    @Autowired
    private RafDuenoDao rafDuenoDao;

    public void save(RafDuenoDto rafDuenoDto) throws MgrException {
        try {
            RafDuenoDto x = rafDuenoDao.selectbyid(rafDuenoDto);
            if (x == null) {
                rafDuenoDao.insert(rafDuenoDto);
            }else{
                rafDuenoDao.update(rafDuenoDto);
            }
        } catch (Exception ex) {
            throw new MgrException(ex);
        }
    }

    public List<RafDuenoDto> getall() throws MgrException {
        try {
            return rafDuenoDao.getall();
        } catch (Exception ex) {
            throw new MgrException(ex);
        }
    }

}
