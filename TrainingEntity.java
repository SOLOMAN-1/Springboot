package entity;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;


@Entity
@Table(name="TrainingData")
public class TrainingEntity {
   @Id
   @GeneratedValue (strategy = GenerationType.SEQUENCE,generator = "training")
   @SequenceGenerator(name = "training",sequenceName = "training_sequence",initialValue = 10000 ,allocationSize = 1)
   private long id;
   @Column(name="name")
   private String name;
   @ElementCollection
   @Column(name="skill")
   private List<String> skill;
   @Enumerated(EnumType.STRING)
   @Column(name="Duration")
    private Duration duration;
   @Column
    private Date start_date;
   @Column
    private Date end_date;
   @Column
    private String student_type;
   @Column
    private long number_of_batches;
   @Column
    private long number_of_students_per_batch;
   @Column
    private double budget;
   @Column
    private String table_of_contents;
   @Column
    private String organization_name;
   @Column
    private String poc;
    @Column
    private String  phone_number;

    @Column
    private String email_id;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    @Column
    private Status status;
    public TrainingEntity() {
    }

    public TrainingEntity(String name, List<String> skill, Duration duration, Date start_date, Date end_date, String student_type, long number_of_batches, double budget, long number_of_students_per_batch, String table_of_contents, String organization_name, String poc, String email_id, String phone_number,Status status) {
        this.name = name;
        this.skill = skill;
        this.duration = duration;
        this.start_date = start_date;
        this.end_date = end_date;
        this.student_type = student_type;
        this.number_of_batches = number_of_batches;
        this.budget = budget;
        this.number_of_students_per_batch = number_of_students_per_batch;
        this.table_of_contents = table_of_contents;
        this.organization_name = organization_name;
        this.poc = poc;
        this.email_id = email_id;
        this.phone_number = phone_number;
        this.status=status;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public Status getStatus() {
        return status;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSkill() {
        return skill;
    }

    public void setSkill(List<String> skill) {
        this.skill = skill;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getStudent_type() {
        return student_type;
    }

    public void setStudent_type(String student_type) {
        this.student_type = student_type;
    }

    public long getNumber_of_batches() {
        return number_of_batches;
    }

    public void setNumber_of_batches(long number_of_batches) {
        this.number_of_batches = number_of_batches;
    }

    public long getNumber_of_students_per_batch() {
        return number_of_students_per_batch;
    }

    public void setNumber_of_students_per_batch(long number_of_students_per_batch) {
        this.number_of_students_per_batch = number_of_students_per_batch;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getTable_of_contents() {
        return table_of_contents;
    }

    public void setTable_of_contents(String table_of_contents) {
        this.table_of_contents = table_of_contents;
    }

    public String getOrganization_name() {
        return organization_name;
    }

    public void setOrganization_name(String organization_name) {
        this.organization_name = organization_name;
    }

    public String getPoc() {
        return poc;
    }

    public void setPoc(String poc) {
        this.poc = poc;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }
    @PrePersist
    @PreUpdate
    public void setStatus(){
        Date date=new Date();
        if(date.before(start_date)){
            this.status=Status.UPCOMING;

        }
        if(date.after(end_date)){
            this.status=Status.COMPLETED;
        }
        if(date.compareTo(start_date)>=0 && date.compareTo(end_date) <= 0){
            this.status=Status.INPROGRESS;
        }
    }
}
