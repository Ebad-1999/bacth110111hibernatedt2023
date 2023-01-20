package hb11.ceritreiaapi;

import com.hb10idgenration.Student10;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RunnerFetch11 {

    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student11.class);


        SessionFactory sf = con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx = session.beginTransaction();


     /*
            CRUD (Create, Read, Update, Delete)
                C-->session.save()
                R-->session.get(), HQL, SQL
                U-->session.update(), updateQuery
                D-->session.delete(), HQL, SQL
         */
        // Long data type use L
        // for float use f.
//
        //1. update using update() method student which  id =1 // write your name .

//        Student11 student=    session.get(Student11.class,1L);
//        System.out.println("Student before update :" +student);
//        student.setName("Updated Student 1");
//        student.setGrade(100);
//        System.out.println("Student after Update :" +student);

        // Update record using query
        // set grades that are less than 75 to 80

//        int sGrade=75;
//        int lGrade=80;
//
//        String hqlQuery="UPDATE Student11 s SET s.grade =:sMath WHERE s.grade<:lMath";
//
//       Query query= session.createQuery(hqlQuery);
//       query.setParameter("sMath" ,sGrade);
//       query.setParameter("lMath",lGrade);
//      int numberOfUpdatedRecord  = query.executeUpdate();
//
//      System.out.println("numberOf record Updated : " +numberOfUpdatedRecord);

      //>= <= write greater  Then ()



      // Criteria API ------------------


       CriteriaBuilder  cb = session.getCriteriaBuilder();
       CriteriaQuery<Student11> criteriaQuery=  cb.createQuery(Student11.class);
       Root<Student11> root= criteriaQuery.from(Student11.class);/// 100 you shuld search 70%   30%

//       // Fetch all Student.
//        criteriaQuery.select(root);// SELECT FROM Student11
//
//        Query<Student11> query1= session.createQuery(criteriaQuery);
//        List<Student11> resultList =  query1.getResultList();
//        resultList.forEach(t-> System.out.println(t));

        ////Example 2 --> get student whose name is "Student Name 8"

//
//          criteriaQuery.select(root).
//                where(cb.equal(root.get("name"),"Student Name 8"));// where Student Name ="Student Name 8"
//         Query query2= session.createQuery(criteriaQuery);
//         List<Student11> resultList2 = query2.getResultList();
//          resultList2.forEach(t-> System.out.println(t));

          // //Example 3 -->Fetch students whose grade is greater than 80;

//        criteriaQuery.select(root).
//                where(cb.lessThanOrEqualTo(root.get("grade"),80));// where grade >80"
//        Query query3= session.createQuery(criteriaQuery);
//        List<Student11> resultList3 = query3.getResultList();
//        resultList3.forEach(t-> System.out.println(t));

        ////Example 4 -->Fetch students whose grade is less than 95;
        criteriaQuery.select(root).
                where(cb.between(root.get("grade"),75,99));// where grade >80"
        Query query4= session.createQuery(criteriaQuery);
        List<Student11> resultList4 = query4.getResultList();
        resultList4.forEach(t-> System.out.println(t));




        tx.commit();
        session.close();
        sf.close();
    }
}
