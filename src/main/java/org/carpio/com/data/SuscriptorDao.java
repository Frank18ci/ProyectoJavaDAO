package org.carpio.com.data;

import org.carpio.com.connection.ConnectionToSql;
import org.carpio.com.domain.Suscriptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SuscriptorDao implements ISuscriptorDao{
    @Override
    public List<Suscriptor> getAllSuscriptors() {
        List<Suscriptor> suscriptors = new ArrayList<>();
        final String sql = "SELECT * FROM suscriptors";
        final Connection connection = ConnectionToSql.getConnection();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try{
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Suscriptor suscriptor = new Suscriptor();
                suscriptor.setIdSuscriptor(resultSet.getInt("idSuscriptor"));
                suscriptor.setName(resultSet.getString("name"));
                suscriptor.setLastname(resultSet.getString("lastname"));
                suscriptor.setNumber(resultSet.getString("number"));
                suscriptor.setIsActive(resultSet.getBoolean("isActive"));
                suscriptor.setIdCinema(resultSet.getInt("idCinema"));
                suscriptors.add(suscriptor);
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return suscriptors;
    }

    @Override
    public Suscriptor getSuscriptorById(Integer id) {
        String sql = "SELECT * FROM suscriptors WHERE idSuscriptor = ?";
        final Connection connection = ConnectionToSql.getConnection();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Suscriptor suscriptor = null;
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                suscriptor = new Suscriptor();
                suscriptor.setIdSuscriptor(resultSet.getInt("idSuscriptor"));
                suscriptor.setName(resultSet.getString("name"));
                suscriptor.setLastname(resultSet.getString("lastname"));
                suscriptor.setNumber(resultSet.getString("number"));
                suscriptor.setIsActive(resultSet.getBoolean("isActive"));
                suscriptor.setIdCinema(resultSet.getInt("idCinema"));
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return suscriptor;
    }

    @Override
    public void addSuscriptor(Suscriptor suscriptor) {
        final String sql = "INSERT INTO suscriptors(name, lastname, number, isActive, idCinema) VALUES(?, ?, ?, ?)";
        final Connection connection = ConnectionToSql.getConnection();
        PreparedStatement preparedStatement;
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, suscriptor.getName());
            preparedStatement.setString(2, suscriptor.getLastname());
            preparedStatement.setString(3, suscriptor.getNumber());
            preparedStatement.setBoolean(4, suscriptor.getIsActive());
            preparedStatement.setInt(5, suscriptor.getIdCinema());
            preparedStatement.execute();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateSuscriptor(Suscriptor suscriptor) {
        final String sql = "UPDATE suscriptors SET name = ?, lastname = ?, number = ?, isActive = ?, idCinema = ? WHERE idSuscriptor = ?";
        final Connection connection = ConnectionToSql.getConnection();
        PreparedStatement preparedStatement;
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, suscriptor.getName());
            preparedStatement.setString(2, suscriptor.getLastname());
            preparedStatement.setString(3, suscriptor.getNumber());
            preparedStatement.setBoolean(4, suscriptor.getIsActive());
            preparedStatement.setInt(5, suscriptor.getIdCinema());
            preparedStatement.setInt(6, suscriptor.getIdSuscriptor());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteSuscriptor(Integer id) {
        final String sql = "DELETE FROM suscriptors WHERE idSuscriptor = ?";
        final Connection connection = ConnectionToSql.getConnection();
        PreparedStatement preparedStatement;
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
