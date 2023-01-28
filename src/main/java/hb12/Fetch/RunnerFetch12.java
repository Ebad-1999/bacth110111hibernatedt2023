package hb12.Fetch;

import hb11.ceritreiaapi.Student11;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch12 {

    public static void main(String[] args) {
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student12.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //testing 1st level cache
        /*
        First level cache works within the same session
         */

        System.out.println("First get methode for student id is 1");
        Student12 student1 = session.get(Student12.class, 1L);

        //session.clear();//clears the cache memory

        System.out.println("Second get methode for student id is 1");
        Student12 student2 = session.get(Student12.class, 1L);








        tx.commit();
        session.close(); //first session closed

        Session session2 = sf.openSession();
        Transaction tx2 = session2.beginTransaction();

        System.out.println("Third get methode for student id is 1 from second session");
        Student12 student3 = session.get(Student12.class, 1L);


        tx.commit();
        session2.close();

        sf.close();
    }
}
