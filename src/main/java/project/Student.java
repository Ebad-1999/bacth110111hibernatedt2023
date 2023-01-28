package project;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String email;



    @ManyToMany
    @JoinTable(name = "Student_Course"
            ,joinColumns = {@JoinColumn(name = "student_id")}, // name for the join table
            inverseJoinColumns ={@JoinColumn(name = "course_id")} )// name of column from parent or superclass
    private List<Course> courseList = new ArrayList<>();//list

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getCourse() {
        return courseList;
    }

    public void setCourse(List<Course> course) {
        this.courseList = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", course=" + courseList +
                '}';
    }
}
