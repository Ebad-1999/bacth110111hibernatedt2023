package project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class RunnerSave {
    public static void main(String[] args) {


        Instructor instructor1 = new Instructor();
        instructor1.setId(101);
        instructor1.setFirstName("Ahmad");
        instructor1.setLastName("Amini");
        instructor1.setEmail("ahmad@gmail");



        Instructor instructor2 = new Instructor();
        instructor2.setId(102);
        instructor2.setFirstName("Salim");
        instructor2.setLastName("saber");
        instructor2.setEmail("salim@gmail");


        Instructor instructor3 = new Instructor();
        instructor3.setId(103);
        instructor3.setFirstName("AhmadJawad");
        instructor3.setLastName("saliehi");
        instructor3.setEmail("salieh@gmail");

        List<Instructor> instructorList = new ArrayList<>();
        instructorList.add(instructor1);
        instructorList.add(instructor2);
        instructorList.add(instructor3);



        InstructorDetail instructorDetail1 = new InstructorDetail();
        instructorDetail1.setId(35);
        instructorDetail1.setYoutube_chanel("Ahmadi.live");
        instructorDetail1.setHobby("FootBall");
        instructorDetail1.setInstructor(instructor1);


        Course course1 = new Course();
        course1.setId(10);
        course1.setTitle("Java");


        Course course2 = new Course();
        course2.setId(11);
        course2.setTitle("HTML");


        Course course3 = new Course();
        course3.setId(12);
        course3.setTitle("CSS");


        Course course4 = new Course();
        course4.setId(13);
        course4.setTitle("BootStrip");


        Course course5 = new Course();
        course5.setId(14);
        course5.setTitle("Hibernate");


        List<Course> courseList1 = new ArrayList<>();
        courseList1.add(course4);
        courseList1.add(course3);
        courseList1.add(course2);

        List<Course> courseList2 = new ArrayList<>();
        courseList2.add(course1);
        courseList2.add(course5);
        courseList2.add(course4);

        List<Course> courseList3 = new ArrayList<>();
        courseList3.add(course3);
        courseList3.add(course4);
        instructor1.setCourse(course1);
        instructor3.setCourse(course2);
        instructor2.setCourse(course1);

        course1.setInstructor(instructorList);
        course2.setInstructor(instructorList);
        course3.setInstructor(instructorList);
        course4.setInstructor(instructorList);
        course5.setInstructor(instructorList);


        Review review1 = new Review();
        review1.setId(1003);
        review1.setComment("good done");

        Review review3 = new Review();
        review3.setId(1004);
        review3.setComment("Great");

        Review review2 = new Review();
        review2.setId(1005);
        review2.setComment("will done");

        List<Review> reviewList1 = new ArrayList<>();
        reviewList1.add(review2);
        reviewList1.add(review3);

        List<Review> reviewList2 = new ArrayList<>();
        reviewList2.add(review2);
        reviewList2.add(review1);

        List<Review> reviewList3 = new ArrayList<>();
        reviewList3.add(review1);
        reviewList3.add(review3);


        course1.setReview(reviewList1);
        course2.setReview(reviewList2);
        course3.setReview(reviewList3);




        Student student1= new Student();
        student1.setId(2003);
        student1.setFirstName("Hasim");
        student1.setLastName("Can");
        student1.setEmail("hashimcan111@gmail.com");
        student1.setCourse(courseList1);

        Student student2= new Student();
        student2.setId(2001);
        student2.setFirstName("Ali");
        student2.setLastName("Armaghan");
        student2.setEmail("ali111@gmail.com");
        student2.setCourse(courseList2);

        Student student3= new Student();
        student3.setId(2004);
        student3.setFirstName("Ebadurrahman");
        student3.setLastName("Musleh");
        student3.setEmail("Emusleh11@gmail.com");
        student3.setCourse(courseList3);




        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).
                addAnnotatedClass(Course.class).
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                addAnnotatedClass(Review.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx = session.beginTransaction();


        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(instructor1);
        session.save(instructor2);
        session.save(instructor3);

        session.save(instructorDetail1);

        session.save(course1);
        session.save(course2);
        session.save(course3);
        session.save(course4);
        session.save(course5);

        session.save(review1);
        session.save(review2);
        session.save(review3);


        tx.commit();
        session.close();
        sf.close();



    }

}
