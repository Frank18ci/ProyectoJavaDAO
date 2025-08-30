package org.carpio.com.data;

import org.carpio.com.domain.Worker;

import java.util.List;

public interface IWorkerDao {
    List<Worker> getAllWorkers();
}
