package com.tbp.crud.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tbp.crud.dao.TrainRepository;
import com.tbp.crud.entity.Train;

@RestController
public class TrainController {
    @Autowired
    TrainRepository trainRepository;

    @PostMapping("/train")
    public ResponseEntity<Train> addTrain(@RequestBody Train train) {

        return new ResponseEntity<>(trainRepository.saveTrain(train),HttpStatus.CREATED);

    }

    @PutMapping("/train")
    public ResponseEntity<Train> updateTrain(@RequestBody Train train) {

        return new ResponseEntity<>(trainRepository.updateTrain(train),HttpStatus.ACCEPTED);

    }

    @GetMapping("/train/{id}")
    public ResponseEntity<Train> getTrain(@PathVariable("id") int id) {
        return new ResponseEntity<>(trainRepository.getById(id),HttpStatus.OK);
    }

    @GetMapping("/trains")
    public ResponseEntity<List<Train>> getTrains() {
        return new ResponseEntity<>(trainRepository.allTrains(),HttpStatus.OK);
    }

    @DeleteMapping("/train/{id}")
    public ResponseEntity<String> deleteTrain(@PathVariable("id") int id){
        return new ResponseEntity<>(trainRepository.deleteById(id),HttpStatus.OK);
    }

}
