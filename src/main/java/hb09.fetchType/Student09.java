package hb09.fetchType;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
  /*
            1. If next side is Many,  then the default fetch type is Lazy
                a.OneToMany
                b.ManyToMany

            2. If next side is One, then the default fetch type is Eager
                a. ManyToOne
                b. OneToOne
     */


@Entity
public class Student09 {
    @Id
    private int id;

    @Column
    private String name;

    @Column
    private int grade;

    @OneToMany(mappedBy = "student" ,fetch = FetchType.LAZY,cascade = CascadeType.ALL)

    private List<Book09> bookLis = new ArrayList<>();

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

    public List<Book09> getBookLis() {
        return bookLis;
    }

    public void setBookLis(List<Book09> bookLis) {
        this.bookLis = bookLis;
    }

    @Override
    public String toString() {
        return "Student09{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", bookLis=" + bookLis +
                '}';
    }
}
