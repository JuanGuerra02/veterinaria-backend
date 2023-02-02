package com.Softcaribean.Veterinaria.dao;

import com.Softcaribean.Veterinaria.database.Managerconexion;
import com.Softcaribean.Veterinaria.dto.RafDuenoDto;
import com.Softcaribean.Veterinaria.dto.RafPacienteDto;
import com.Softcaribean.Veterinaria.exception.DaoException;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class RafDuenoDaoImpl implements RafDuenoDao{

    public void insert(RafDuenoDto rafDuenoDto) throws DaoException {

        String INSERT = "insert into raf_dueno  \n" +
                "(nmid,dsnombre,dsidentificacion,dsdireccion,dstelefono,nmciudadid,nmtipidenid)\n" +
                " values (?,?,?,?,?,?,?);";
        PreparedStatement statement = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(INSERT);
            statement.setInt(1, rafDuenoDto.getNmid());
            statement.setString(1, rafDuenoDto.getDsnombre());
            statement.setString(2, rafDuenoDto.getDsidentificacion());
            statement.setString(3, rafDuenoDto.getDsdireccion());
            statement.setString(4, rafDuenoDto.getDstelefono());
            statement.setInt(5, rafDuenoDto.getNmciudadid());
            statement.setInt(6, rafDuenoDto.getNmtipidenid());
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

    public void update(RafDuenoDto rafDuenoDto) throws DaoException {
        String UPDATE = "UPDATE raf_dueno SET \n"+
                "dsnombre=?,dsidentificacion=?,dsdireccion=?,dstelefono=?,nmciudadid=?,nmtipidenid=? \n" +
                "where nmid=?";
        PreparedStatement statement = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, rafDuenoDto.getDsnombre());
            statement.setString(2, rafDuenoDto.getDsidentificacion());
            statement.setString(3, rafDuenoDto.getDsdireccion());
            statement.setString(4, rafDuenoDto.getDstelefono());
            statement.setInt(5, rafDuenoDto.getNmciudadid());
            statement.setInt(6, rafDuenoDto.getNmtipidenid());
            statement.setInt(7, rafDuenoDto.getNmid());
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

    public RafDuenoDto selectbyid(RafDuenoDto rafDuenoDto) throws DaoException {
        RafDuenoDto result = null;
        String SELECT = " SELECT * from raf_dueno where nmid=?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(SELECT);
            statement.setInt(1, rafDuenoDto.getNmid());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result = new RafDuenoDto();
                result.setNmid(resultSet.getInt("nmid"));
                result.setDsnombre(resultSet.getString("dsnombre"));
                result.setDsidentificacion(resultSet.getString("dsidentificacion"));
                result.setDsdireccion(resultSet.getString("dsdireccion"));
                result.setDstelefono(resultSet.getString("dstelefono"));
                result.setNmciudadid(resultSet.getInt("nmciudadid"));
                result.setNmtipidenid(resultSet.getInt("nmtipidenid"));
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

    public List<RafDuenoDto> getall()throws DaoException {
        List<RafDuenoDto> list = new ArrayList<>();
        String SELECT="select * from raf_dueno; ";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(SELECT);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                RafDuenoDto rafDuenoDto = new RafDuenoDto();
                rafDuenoDto.setNmid(resultSet.getInt("nmid"));
                rafDuenoDto.setDsnombre(resultSet.getString("dsnombre"));
                rafDuenoDto.setDsdireccion(resultSet.getString("dsidentificacion"));
                rafDuenoDto.setDsidentificacion(resultSet.getString("dsdireccion"));
                rafDuenoDto.setDstelefono(resultSet.getString("dstelefono"));
                rafDuenoDto.setNmciudadid(resultSet.getInt("nmciudadid"));
                rafDuenoDto.setNmtipidenid(resultSet.getInt("nmtipidenid"));
                list.add(rafDuenoDto);
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
