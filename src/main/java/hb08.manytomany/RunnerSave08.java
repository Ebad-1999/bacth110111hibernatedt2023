package hb08.manytomany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class RunnerSave08 {

    public static void main(String[] args) {

        //create object from students

        Student08 student1= new Student08();
        student1.setId(1001);
        student1.setName("AAA");
        student1.setGrade(90);

        Student08 student2= new Student08();
        student2.setId(1002);
        student2.setName("BBB");
        student2.setGrade(80);


        Student08 student3= new Student08();
        student3.setId(1003);
        student3.setName("CCC");
        student3.setGrade(90);

        // Create Book Object
        Book08 book1 = new Book08();
        book1.setId(101);
        book1.setName("java Book");

        Book08 book2 = new Book08();
        book2.setId(102);
        book2.setName("hibernate  Book");

        Book08 book3 = new Book08();
        book3.setId(103);
        book3.setName("Html Book");

        List<Book08> bookList1= new ArrayList<>();
        bookList1.add(book1);
        bookList1.add(book2);

        student1.setBookList(bookList1);

        List<Book08> bookList2= new ArrayList<>();
        bookList2.add(book2);
        bookList2.add(book3);

        student2.setBookList(bookList2);


        List<Book08> bookList3= new ArrayList<>();
        bookList3.add(book1);
        bookList3.add(book3);
        student3.setBookList(bookList3);



        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student08.class).
                addAnnotatedClass(Book08.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx = session.beginTransaction();
        // save student object
        session.save(student1);
        session.save(student2);
        session.save(student3);

        // save book object
        session.save(book1);
        session.save(book2);
        session.save(book3);


        tx.commit();
        session.close();
        sf.close();
    }
}
