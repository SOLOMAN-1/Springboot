package repository;

import entity.TrainingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<TrainingEntity, Long> {
    List<TrainingEntity>findByDateBetween(Date start_date, Date end_date);
    List<TrainingEntity>findByStartDate(Date start_date);
    List<TrainingEntity>findBySkills(String Skills);
    List<TrainingEntity>findByOrganizationName(String name);

}

