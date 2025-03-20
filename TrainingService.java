package service;

import entity.TrainingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TrainingRepository;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TrainingService {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    @Autowired
    TrainingRepository train;
    public List<TrainingEntity> getTrainingByDate(Date start_date, Date end_date){
        if(end_date==null){
            List <TrainingEntity> trainingBasedStartDate=train.findByStartDate(start_date);
            return trainingBasedStartDate;
        }
        else {

            List<TrainingEntity> trainingBasedDate = train.findByDateBetween(start_date, end_date);
            return trainingBasedDate;
            }

    }
    public List<TrainingEntity> getTrainingBasedSkill(String Skill){
        List <TrainingEntity> trainingBasedSkill=train.findBySkills(Skill);
        return trainingBasedSkill;
    }
    public List<TrainingEntity> getTrainingBasedOrganizationName(String name){
        List<TrainingEntity>trainingBasedOrganization=train.findByOrganizationName(name);
        return trainingBasedOrganization;
    }
    public TrainingEntity addATraining(TrainingEntity train1){
       String phone_number=train1.getPhone_number();
       if(phone_number.length()!=10){
           throw new IllegalArgumentException("Phone number must be a ten-digit number");

       }
       else{
           for (char ch :phone_number.toCharArray()){
               if(!Character.isDigit(ch)){
                   throw new IllegalArgumentException("Phone number must contain only digits");

               }
           }


       }
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(train1.getEmail_id());
        if( !matcher.matches()){
            throw new IllegalArgumentException("Enter Correct email id");
        }
        train.save(train1);
        return  train1;
    }
}
