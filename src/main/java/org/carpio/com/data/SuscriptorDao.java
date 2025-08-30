package org.carpio.com.data;

import org.carpio.com.connection.ConnectionToSql;
import org.carpio.com.domain.Suscriptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
