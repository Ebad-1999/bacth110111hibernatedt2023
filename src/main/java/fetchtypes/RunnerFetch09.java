package fetchtypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch09 {
    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student09.class).
                addAnnotatedClass(Book09.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx = session.beginTransaction();

        //get and delete
        //Student09 student091 = session.get(Student09.class, 1002);
        //System.out.println(student091);
        //session.delete(student091);

        //when it is Eager, in student2 variable, we have stord all information about student and book
        Student09 student2 = session.get(Student09.class, 1001);
        System.out.println(student2.getName());




        tx.commit();
        session.close();
        sf.close();

        for(Book09 book: student2.getBookList()){
            System.out.println(book);
        }

    }


















}
