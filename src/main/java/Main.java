import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int id = sc.nextInt();
//        System.out.println("Please enter your name: ");
//        String name = sc.next();
//        System.out.println("Please enter your marks: ");
//        int marks = sc.nextInt();
//        System.out.println("Please enter your email: ");
//        String email = sc.next();
//        Student student = new Student(name, marks, email);
        Configuration conf =  new Configuration();
        conf.configure("hibernate.cfg.xml");
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
//        session.persist(student);
        Student studentGet = session.get(Student.class, id);
        System.out.println(studentGet.toString());
        tx.commit();
        session.close();
        factory.close();
    }
}
