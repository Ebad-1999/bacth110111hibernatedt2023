package hb09.fetchType;

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

        // using get method



       Student09 student=  session.get(Student09.class,1002);
        System.out.println(student.getName());

        System.out.println("-------------------");

        Student09 student1=  session.get(Student09.class,1002);
        session.delete(student1);

        tx.commit();
        session.close();
        sf.close();
    }
}
