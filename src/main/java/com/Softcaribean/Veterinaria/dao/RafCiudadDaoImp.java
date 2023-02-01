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

    public void insert(RafCiudadDto rafCiudadDto) throws DaoException {

        String INSERT = "insert into raf_ciudad (dsnombre) values (?);";
        PreparedStatement statement = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(INSERT);
            statement.setString(1, rafCiudadDto.getDsnombre());
            statement.executeUpdate();
        } catch (Exception ex) {
            throw new DaoException(ex);
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void update(RafCiudadDto rafCiudadDto) throws DaoException {
        String UPDATE = "UPDATE raf_ciudad SET  dsnombre=? where nmid=?";
        PreparedStatement statement = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, rafCiudadDto.getDsnombre());
            statement.setInt(2, rafCiudadDto.getNmid());
            statement.executeUpdate();
        } catch (Exception ex) {
            throw new DaoException(ex);
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public RafCiudadDto selectbyid(RafCiudadDto rafCiudadDto) throws DaoException {
        RafCiudadDto result = null;
        String SELECT = " SELECT * from raf_ciudad where nmid=?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(SELECT);
            statement.setInt(1, rafCiudadDto.getNmid());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result = new RafCiudadDto();
                result.setNmid(resultSet.getInt("nmid"));
                result.setDsnombre(resultSet.getString("dsnombre"));
            }
        } catch (Exception ex) {
            throw new DaoException(ex);
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

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
