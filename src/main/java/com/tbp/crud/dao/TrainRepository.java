package com.tbp.crud.dao;

import java.util.List;

import com.tbp.crud.entity.Train;

public interface TrainRepository {
    Train saveTrain(Train train);

    Train updateTrain(Train train);

    Train getById(int id);

    String deleteById(int id);

    List<Train> allTrains();
}
