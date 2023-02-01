package com.Softcaribean.Veterinaria.dao;

import com.Softcaribean.Veterinaria.database.Managerconexion;
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
public class RafPacienteDaoImpl implements RafPacienteDao{

    public void insert(RafPacienteDto rafPacienteDto) throws DaoException {

        String INSERT = "insert into raf_paciente \n" +
                "(dsnombre,dsraza,dtfechanacimiento,dtfecharegistro,nmtippaciid,nmduenoid)\n" +
                " values (?,?,?,?,?,?);";
        PreparedStatement statement = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(INSERT);
            statement.setString(1, rafPacienteDto.getDsnombre());
            statement.setString(2, rafPacienteDto.getDsraza());
            statement.setDate(3, rafPacienteDto.getDtfechanacimiento());
            statement.setDate(4, rafPacienteDto.getDtfecharegistro());
            statement.setInt(5, rafPacienteDto.getNmtippaciid());
            statement.setInt(6, rafPacienteDto.getNmduenoid());
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

    public void update(RafPacienteDto rafPacienteDto) throws DaoException {
        String UPDATE = "UPDATE raf_paciente SET \n"+
                "dsnombre=?,dsraza=?,dtfechanacimiento=?,dtfecharegistro=?,nmtippaciid=?,nmduenoid=? \n" +
                "where nmid=?";
        PreparedStatement statement = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, rafPacienteDto.getDsnombre());
            statement.setString(2, rafPacienteDto.getDsraza());
            statement.setDate(3, rafPacienteDto.getDtfechanacimiento());
            statement.setDate(4, rafPacienteDto.getDtfecharegistro());
            statement.setInt(5, rafPacienteDto.getNmtippaciid());
            statement.setInt(6, rafPacienteDto.getNmduenoid());
            statement.setInt(7, rafPacienteDto.getNmid());
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

    public RafPacienteDto selectbyid(RafPacienteDto rafPacienteDto) throws DaoException {
        RafPacienteDto result = null;
        String SELECT = " SELECT * from raf_paciente where nmid=?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(SELECT);
            statement.setInt(1, rafPacienteDto.getNmid());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result = new RafPacienteDto();
                result.setNmid(resultSet.getInt("nmid"));
                result.setDsnombre(resultSet.getString("dsnombre"));
                result.setDsraza(resultSet.getString("dsraza"));
                result.setDtfechanacimiento(resultSet.getDate("dtfechanacimiento"));
                result.setDtfecharegistro(resultSet.getDate("dtfecharegistro"));
                result.setNmtippaciid(resultSet.getInt("nmtippaciid"));
                result.setNmduenoid(resultSet.getInt("nmduenoid"));
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

    public List<RafPacienteDto> getall()throws DaoException {
        List<RafPacienteDto> list = new ArrayList<>();
        String SELECT="select * from raf_paciente; ";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = Managerconexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(SELECT);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                RafPacienteDto rafPacienteDto = new RafPacienteDto();
                rafPacienteDto.setNmid(resultSet.getInt("nmid"));
                rafPacienteDto.setDsnombre(resultSet.getString("dsnombre"));
                rafPacienteDto.setDsraza(resultSet.getString("dsraza"));
                rafPacienteDto.setDtfechanacimiento(resultSet.getDate("dtfechanacimiento"));
                rafPacienteDto.setDtfecharegistro(resultSet.getDate("dtfecharegistro"));
                rafPacienteDto.setNmtippaciid(resultSet.getInt("nmtippaciid"));
                rafPacienteDto.setNmduenoid(resultSet.getInt("nmduenoid"));
                list.add(rafPacienteDto);
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
