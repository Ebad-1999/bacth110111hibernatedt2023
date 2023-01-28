package hb07.bi_onttomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch07 {
    public static void main(String[] args) {
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).
                addAnnotatedClass(Book07.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx = session.beginTransaction();

        //fetch objects using get()

        //Student07 student1 = session.get(Student07.class, 1001);
        //System.out.println("student1: "+ student1 );
       // System.out.println(student1.getBookList());
        //student1.getBookList().forEach(std-> System.out.println(std)); //using lambda

        //student1.getBookList().forEach(System.out::println);//method reference

//        Book07 book1 =  session.get(Book07.class, 101);
//        System.out.println(book1);
//        System.out.println(book1.getStudent());

        // using SQL query, fetch  name of book and student from students who has book

//        String sqlQuery1 = "SELECT s.std_name, b.name FROM t_student07 s INNER JOIN t_book07 b ON s.id = b.student_id";
//
//        List<Object[]> resultList1 = session.createSQLQuery(sqlQuery1).getResultList();
//        for(Object[] obj: resultList1){
//            System.out.println(Arrays.toString(obj));
//        }

        // using HQL query, fetch  name of book and student from students who has book

//        String hqlQuery = "Select s.name, b.name from Student07 s inner join Book07 b on s.id = b.student.id";
//        List<Object[]> res = session.createQuery(hqlQuery).getResultList();
//        for (Object[] o: res){
//            System.out.println("Arrays.toString(o) = " + Arrays.toString(o));
//        }


        // DELETE records of Book07 using SQL

//        String sqlQuery2 = "DELETE FROM t_book07";
//        int numberOfDeletedRecords =  session.createSQLQuery(sqlQuery2).executeUpdate();
//        System.out.println("Number of deleted queries : "+numberOfDeletedRecords);

//        String sqlQuery3 = "DELETE FROM t_student07";
//        int numberOfDeletedRecords1 =  session.createSQLQuery(sqlQuery3).executeUpdate();
//        System.out.println("Number of deleted queries : "+numberOfDeletedRecords1);


        // DELETE records of Book07 using SQL
//        String hqlQuery2 = "DELETE FROM Book07";
//        int numberOfDeletedRecords4 =  session.createQuery(hqlQuery2).executeUpdate();
//        System.out.println("Number of deleted queries : "+numberOfDeletedRecords4);

//        String hqlQuery3 = "DELETE FROM Student07";
//        int numberOfDeletedRecords5 =  session.createQuery(hqlQuery3).executeUpdate();
//        System.out.println("Number of deleted queries : "+numberOfDeletedRecords5);

        //Delete Book record which is named as "Art Book" using hql"

//        String hqlQuery3 ="DELETE FROM Book07 b WHERE b.name = 'Art Book'";
//        int numOfDeleteReord4 = session.createQuery(hqlQuery3).executeUpdate();
//        System.out.println(numOfDeleteReord4);

        Student07 std = session.get(Student07.class, 1002);
        session.delete(std);


        String hqlQuery = "FROM Student07 s JOIN name s.bookList b Where b.name LIKE '%java";




        tx.commit();
        session.close();
        sf.close();

        












    }
}
