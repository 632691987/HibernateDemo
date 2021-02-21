package hibernate.demo.service;

import hibernate.demo.entity.Student;
import org.hibernate.Session;

import javax.persistence.TypedQuery;

public class StudentDAO {

    public Student getStudentByName(Session session, String name) {
        TypedQuery<Student> query = session.createQuery("select p from Student p where p.name = :name", Student.class);
        query.setParameter("name", name);

        return query.getSingleResult();
    }

    public Student getStudentByName2(Session session, String name) {
        TypedQuery<Student> query = session.createNamedQuery("findStudentByName", Student.class);
        query.setParameter("name", name);

        return query.getSingleResult();
    }

    public Student getSudentById(Session session, int id) {
        return session.get(Student.class, id);
    }


}
