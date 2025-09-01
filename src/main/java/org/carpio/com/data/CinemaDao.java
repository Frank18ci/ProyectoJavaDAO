package org.carpio.com.data;

import org.carpio.com.connection.ConnectionToSql;
import org.carpio.com.domain.Cinema;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CinemaDao implements ICinemaDao{
    @Override
    public List<Cinema> getAllCinemas() {
        List<Cinema> cinemas = new ArrayList<>();
        final String sql = "SELECT * FROM cinema";
        final Connection connection = ConnectionToSql.getConnection();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try{
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Cinema cinema = new Cinema();
                cinema.setIdCinema(resultSet.getInt("idCinema"));
                cinema.setName(resultSet.getString("name"));
                cinema.setDirection(resultSet.getString("direction"));
                cinemas.add(cinema);
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return cinemas;
    }

    @Override
    public Cinema getCinemaById(Integer id) {
        return null;
    }

    @Override
    public Boolean addCinema(Cinema cinema) {
        final String sql = "INSERT INTO cinema(name, direction) VALUES(?, ?)";
        final Connection connection = ConnectionToSql.getConnection();
        PreparedStatement preparedStatement;
        final ResultSet resultSet;
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cinema.getName());
            preparedStatement.setString(2, cinema.getDirection());
            preparedStatement.execute();
            return true;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCinema(Cinema cinema) {
        final String sql = "UPDATE cinema SET name = ?, direction = ? WHERE idCinema = ?";
        final Connection connection = ConnectionToSql.getConnection();
        PreparedStatement preparedStatement;
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cinema.getName());
            preparedStatement.setString(2, cinema.getDirection());
            preparedStatement.setInt(3, cinema.getIdCinema());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCinema(Integer id) {
        final String sql = "DELETE FROM cinema WHERE idCinema = ?";
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
