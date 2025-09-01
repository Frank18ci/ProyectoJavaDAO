package org.carpio.com.data;

import org.carpio.com.domain.Suscriptor;

import java.util.List;

public interface ISuscriptorDao {
    List<Suscriptor> getAllSuscriptors();
    Suscriptor getSuscriptorById(Integer id);
    void addSuscriptor(Suscriptor suscriptor);
    void updateSuscriptor(Suscriptor suscriptor);
    void deleteSuscriptor(Integer id);
}
