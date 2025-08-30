package org.carpio.com.data;

import org.carpio.com.connection.ConnectionToSql;
import org.carpio.com.domain.Suscriptor;
import org.carpio.com.domain.Worker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
