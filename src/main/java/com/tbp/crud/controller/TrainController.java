package com.tbp.crud.controller;

import com.tbp.crud.dao.TrainRepository;
import com.tbp.crud.entity.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrainController {
    @Autowired
    TrainRepository trainRepository;

    @PostMapping("/train")
    public Train addTrain(@RequestBody Train train) {

        return trainRepository.saveTrain(train);

    }

    @PutMapping("/train")
    public Train updateTrain(@RequestBody Train train) {

        return trainRepository.updateTrain(train);

    }

    @GetMapping("/train/{id}")
    public Train getTrain(@PathVariable("id") int id) {
        return trainRepository.getById(id);
    }

    @GetMapping("/trains")
    public List<Train> getTrains() {
        return trainRepository.allTrains();
    }

    @DeleteMapping("/train/{id}")
    public String deleteTrain(@PathVariable("id") int id){
        return trainRepository.deleteById(id);
    }

}
