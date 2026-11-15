package org.example;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class student {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Long id;
    private String RollNumber;
    private String studentName;
    private String course;

    public student(String RollNumber,String studentName,String course) {
       this.RollNumber=RollNumber;
       this.studentName=studentName;
       this.course=course;
    }


    public student(Long id, String rollNumber, String studentName, String course) {
        this.id = id;
        RollNumber = rollNumber;
        this.studentName = studentName;
        this.course = course;
    }

    public student() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRollNumber() {
        return RollNumber;
    }

    public void setRollNumber(String rollNumber) {
        RollNumber = rollNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", RollNumber='" + RollNumber + '\'' +
                ", studentName='" + studentName + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}





