package hb08.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student08 {

    @Id
    private int id;

    @Column(name = "student_name",nullable = false)
    private String name;

    @Column(length = 100)
    private int grade;


    // setup relationship

    @ManyToMany
    @JoinTable(name = "Student08_Book08"
    ,joinColumns = {@JoinColumn(name = "std_id")}, // name for the join table
    inverseJoinColumns ={@JoinColumn(name = "book_id")} )// name of column from parent or superclass
    private List<Book08> bookList = new ArrayList<>();// name of column where id of other table

    // getter and setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Book08> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book08> bookList) {
        this.bookList = bookList;
    }

    // toString Method


    @Override
    public String toString() {
        return "Student08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", bookList=" + bookList +
                '}';
    }
}
