package org.carpio.com;

import org.carpio.com.data.CinemaDao;
import org.carpio.com.data.SuscriptorDao;
import org.carpio.com.data.WorkerDao;
import org.carpio.com.domain.Cinema;
import org.carpio.com.domain.Suscriptor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        CinemaDao cinemaDao = new CinemaDao();
        System.out.println("Lista de cines");
        cinemaDao.getAllCinemas().forEach(System.out::println);
        System.out.println("---------------------");
        SuscriptorDao suscriptorDao = new SuscriptorDao();
        System.out.println("Lista de suscriptores");
        suscriptorDao.getAllSuscriptors().forEach(System.out::println);
        System.out.println("---------------------");
        WorkerDao workerDao = new WorkerDao();
        System.out.println("Lista de trabajadores");
        workerDao.getAllWorkers().forEach(System.out::println);
        System.out.println("---------------------");
        Cinema cinema = new Cinema();
        cinema.setDirection("Av Siempre Viva 123");
        cinema.setName("Cinepolis");
        // Comented to avoid duplicate entries
        //cinemaDao.addCinema(cinema);
        //cinemaDao.deleteCinema(5);

        //cinemaDao.getAllCinemas().forEach(System.out::println);
    }
}