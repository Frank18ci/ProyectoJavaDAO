package org.carpio.com.data;

import org.carpio.com.connection.ConnectionToSql;
import org.carpio.com.domain.Suscriptor;
import org.carpio.com.domain.Worker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkerDao implements IWorkerDao{

    @Override
    public List<Worker> getAllWorkers() {
        List<Worker> workers = new ArrayList<>();
        final String sql = "SELECT * FROM workers";
        final Connection connection = ConnectionToSql.getConnection();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try{
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Worker worker = new Worker();
                worker.setIdWorker(resultSet.getInt("idWorker"));
                worker.setName(resultSet.getString("name"));
                worker.setLastName(resultSet.getString("lastName"));
                worker.setDirection(resultSet.getString("direction"));
                worker.setNumber(resultSet.getString("number"));
                worker.setIdCinema(resultSet.getInt("idCinema"));
                workers.add(worker);
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return workers;
    }

    @Override
    public Worker getWorkerById(Integer id) {
        String sql = "SELECT * FROM workers WHERE idWorker = ?";
        final Connection connection = ConnectionToSql.getConnection();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Worker worker = null;
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                worker = new Worker();
                worker.setIdWorker(resultSet.getInt("idWorker"));
                worker.setName(resultSet.getString("name"));
                worker.setLastName(resultSet.getString("lastName"));
                worker.setDirection(resultSet.getString("direction"));
                worker.setNumber(resultSet.getString("number"));
                worker.setIdCinema(resultSet.getInt("idCinema"));
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return worker;
    }

    @Override
    public void addWorker(Worker worker) {
        final String sql = "INSERT INTO workers(name, lastName, direction, number, idCinema) VALUES(?, ?, ?, ?, ?)";
        final Connection connection = ConnectionToSql.getConnection();
        PreparedStatement preparedStatement;
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, worker.getName());
            preparedStatement.setString(2, worker.getLastName());
            preparedStatement.setString(3, worker.getDirection());
            preparedStatement.setString(4, worker.getNumber());
            preparedStatement.setInt(5, worker.getIdCinema());
            preparedStatement.execute();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateWorker(Worker worker) {
        final String sql = "UPDATE workers SET name = ?, lastName = ?, direction = ?, number = ?, idCinema = ? WHERE idWorker = ?";
        final Connection connection = ConnectionToSql.getConnection();
        PreparedStatement preparedStatement;
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, worker.getName());
            preparedStatement.setString(2, worker.getLastName());
            preparedStatement.setString(3, worker.getDirection());
            preparedStatement.setString(4, worker.getNumber());
            preparedStatement.setInt(5, worker.getIdCinema());
            preparedStatement.setInt(6, worker.getIdWorker());
            preparedStatement.execute();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteWorker(Integer id) {
        String sql = "DELETE FROM workers WHERE idWorker = ?";
        Connection connection = ConnectionToSql.getConnection();
        PreparedStatement preparedStatement;
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
