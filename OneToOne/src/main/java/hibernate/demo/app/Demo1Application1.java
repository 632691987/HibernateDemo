package hibernate.demo.app;

import hibernate.demo.entity.Desktop;
import hibernate.demo.entity.Student;
import hibernate.demo.service.HibernateUtil;
import org.hibernate.Session;

public class Demo1Application1 {

    public static void main(String[] args) {
        System.out.println("Hibernate one to one (Annotation)");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Student student = new Student();
        student.setAge(38);
        student.setName("Vincent2");

        Desktop desktop = new Desktop();
        desktop.setDeskNo(3);
        desktop.setStudent(student);

        session.persist(student);
        session.persist(desktop);
        session.getTransaction().commit();
        System.out.println("============================1==========================");
        System.out.println(student.getId());
    }

}
