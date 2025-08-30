package org.carpio.com.data;

import org.carpio.com.domain.Cinema;

import java.util.List;

public interface ICinemaDao {
    List<Cinema> getAllCinemas();
    Cinema getCinemaById(Integer id);
    Boolean addCinema(Cinema cinema);
    void updateCinema(Cinema cinema);
    void deleteCinema(Integer id);
}
