package hb08.manytomany;

import com.hb07.bi_onetomany.Book07;
import com.hb07.bi_onetomany.Student07;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch08 {

    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student08.class).
                addAnnotatedClass(Book08.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx = session.beginTransaction();


      try {


          // use get() and fetch student or book


          System.out.println("--------------------");
           Student08 std=   session.get(Student08.class,1002);
          //  System.out.println(std);
          System.out.println(std.getBookList());



          /// use get method to retrieve book
          System.out.println("-------------------------");

          Book08 book1 = session.get(Book08.class,101);
          System.out.println(book1);
          System.out.println(book1.getStudents());

          System.out.println("-------------------------");

      }finally {
        tx.commit();
        session.close();
        sf.close();
      }



    }
}
