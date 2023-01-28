package project;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    private int id;
    private String title;

    @OneToMany(mappedBy = "course")
    private List<Instructor> instructor = new ArrayList<>();//list

    @OneToMany(mappedBy = "course")

    private List<Review> review= new ArrayList<>();//list

    @ManyToMany(mappedBy = "courseList")
    private List<Student> student = new ArrayList<>();//list

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Instructor> getInstructor() {
        return instructor;
    }

    public void setInstructor(List<Instructor> instructor) {
        this.instructor = instructor;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", instructor=" + instructor +
                ", review=" + review +
                ", student=" + student +
                '}';
    }
}
