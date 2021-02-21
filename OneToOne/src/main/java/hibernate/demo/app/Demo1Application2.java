package hibernate.demo.app;

import hibernate.demo.entity.Desktop;
import hibernate.demo.entity.Student;
import hibernate.demo.service.DesktopDAO;
import hibernate.demo.service.HibernateUtil;
import hibernate.demo.service.StudentDAO;
import org.hibernate.Session;

public class Demo1Application2 {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        StudentDAO studentDAO = new StudentDAO();
        DesktopDAO desktopDAO = new DesktopDAO();

        Student student = studentDAO.getStudentByName(session, "vincent");
        Student student2 = studentDAO.getStudentByName2(session, "vincent");

        //Desktop desktop = desktopDAO.getDesktopByStudent(session, student2);
    }
}
