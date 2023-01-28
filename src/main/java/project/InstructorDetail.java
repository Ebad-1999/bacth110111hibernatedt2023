package project;

import javax.persistence.*;

@Entity
@Table(name = "instructorDetail")
public class InstructorDetail {

    @Id
    private int id;
    private String youtube_chanel;
    private String hobby;

    @OneToOne
    @JoinColumn
    private Instructor instructor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutube_chanel() {
        return youtube_chanel;
    }

    public void setYoutube_chanel(String youtube_chanel) {
        this.youtube_chanel = youtube_chanel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtube_chanel='" + youtube_chanel + '\'' +
                ", hobby='" + hobby + '\'' +
                ", instructor=" + instructor +
                '}';
    }
}
