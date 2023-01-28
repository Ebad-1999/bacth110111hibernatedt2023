package hb14.entity_life_cycle;
import hb14.entity_life_cycle.Student14;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave14 {
    public static void main(String[] args) {


        Student14 student1 = new Student14(); //transient state--> hibernate has no responsibility

        student1.setName("AAA");
        student1.setGrade(98);

        Student14 student2 = new Student14();

        student2.setName("BBB");
        student2.setGrade(98);

        Student14 student3 = new Student14();

        student3.setName("CCC");
        student3.setGrade(98);


        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student14.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        session.save(student1); //Persistent -> hibernate will get this object under its control

        student1.setName("Updated AAA");

        session.evict(student1); // detached state-->Remove this instance from the session cache. Changes to the instance will
        // not be synchronized with the database.
        session.clear();  //detached state


        session.update(student1); //detached obj will move to persistent state
        session.merge(student1); //detached obj will move to persistent state

        tx.commit();
        session.close();
        sf.close();
    }
}