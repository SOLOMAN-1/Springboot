package controller;

import entity.TrainingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import service.TrainingService;
import java.util.Date;
import java.util.List;

@Repository
@RequestMapping("/training")
public class TrainingController {
    @Autowired
    TrainingService trainingService;
    @GetMapping("/byDate/{Date1}-{Date2}")
    public ResponseEntity<List<TrainingEntity>> getTrainingByDate(@PathVariable Date Date1,@PathVariable Date Date2 ){
        List<TrainingEntity>trainingBaseddates=trainingService.getTrainingByDate(Date1,Date2);
        return  new ResponseEntity<>(trainingBaseddates, HttpStatus.OK);
    }
    @PostMapping("/add")
    public  ResponseEntity<TrainingEntity> addTraining(@RequestBody TrainingEntity train){
        TrainingEntity train1=trainingService.addATraining(train);
        return new ResponseEntity<>(train1,HttpStatus.CREATED);
    }
}
