package com.Softcaribean.Veterinaria.dao;

import com.Softcaribean.Veterinaria.database.Managerconexion;
import com.Softcaribean.Veterinaria.dto.RafCiudadDto;
import com.Softcaribean.Veterinaria.exception.DaoException;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class RafCiudadDaoImp implements RafCiudadDao {

    public List<RafCiudadDto> getall()throws DaoException {
        List<RafCiudadDto> list = new ArrayList<>();
        String SELECT="select * from raf_ciudad; ";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(SELECT);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                RafCiudadDto rafciudadcto = new RafCiudadDto();
                rafciudadcto.setNmid(resultSet.getInt("nmid"));
                rafciudadcto.setDsnombre(resultSet.getString("dsnombre"));
                list.add(rafciudadcto);
            }
        }catch (Exception ex) {
            throw new DaoException(ex);
        }finally {
            try {
                resultSet.close();
                statement.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return list;
    }
}
