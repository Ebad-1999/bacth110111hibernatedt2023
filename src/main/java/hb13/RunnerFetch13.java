package hb13;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch13 {
    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student13.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("********get method starts*********");
        Student13 student1 = session.get(Student13.class, 1L);
        System.out.println(student1.getName());
        System.out.println(student1.getGrade());

        System.out.println("************* get method ends********");
        System.out.println("********load method starts*********");
        Student13 student2 = session.load(Student13.class, 2L);

        System.out.println("********getName method starts*********");
        System.out.println(student2.getName());
        System.out.println(student2.getGrade());
        System.out.println("************* load method ends********");

        System.out.println("********get method starts for record which does not exist*********");
        Student13 student3 = session.load(Student13.class, 6L);
        System.out.println("Student which is 6:" + student3);
        System.out.println("********get method ends for record which does not exist*********");

        System.out.println("********load method starts for record which does not exist*********");
        Student13 student4 = session.load(Student13.class, 8L);
        //System.out.println("Student which is 8:" + student4);
        System.out.println("********load method ends for record which does not exist*********");


        Student13 student5 = session.get(Student13.class, 2L);
        session.delete(student5);

        Student13 student6 = session.load(Student13.class, 2L);
        session.delete(student5);











        tx.commit();
        session.close();
        sf.close();

    }
}
