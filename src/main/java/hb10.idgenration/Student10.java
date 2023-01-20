package hb10.idgenration;

import javax.persistence.*;

@Entity
public class Student10 {

    @Id
    @GeneratedValue(generator = "sequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence",// should be math   @SequenceGenerator 's attribute "generator"
            sequenceName = "std_seq",// sequence name on Db
            initialValue = 100,
            allocationSize = 10// reserve id
    )

    private int id;

    @Column(name = "student_name")
    private String name;

    @Column
    private int grade;

    // getter / setter


    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

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

    // toString Method


    @Override
    public String toString() {
        return "Student10{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
