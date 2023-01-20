package hb10.idgenration;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave10 {

    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student10.class);


        SessionFactory sf = con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx = session.beginTransaction();


        Student10 student1= new Student10();

        student1.setName("Ebad");
        student1.setGrade(90);

        Student10 student2= new Student10();

        student2.setName("Omer");
        student2.setGrade(97);

        Student10 student3= new Student10();

        student3.setName("Fatih");
        student3.setGrade(81);

        Student10 student4= new Student10();

        student4.setName("Tarik");
        student4.setGrade(80);


        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);

        tx.commit();
        session.close();
        sf.close();

    }
}
