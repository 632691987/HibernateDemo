package hibernate.demo.app;

import hibernate.demo.entity.Student;
import hibernate.demo.service.DesktopDAO;
import hibernate.demo.service.HibernateUtil;
import hibernate.demo.service.StudentDAO;
import org.hibernate.Session;

public class Demo1Application3 {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        StudentDAO studentDAO = new StudentDAO();

        Student student = studentDAO.getSudentById(session, 1);
        System.out.println("================================1=================================");
        student = studentDAO.getSudentById(session, 1);
        System.out.println("================================2=================================");

        Session session2 = HibernateUtil.getSessionFactory().openSession();
        student = studentDAO.getSudentById(session2, 1);
        System.out.println("================================3=================================");

        session.close();
        session2.close();
        System.out.println("================================4=================================");

    }
}
