package hibernate.demo.service;

import hibernate.demo.entity.Desktop;
import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.TypedQuery;

public class DesktopDAO {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public Desktop getDesktopByStudent(Session session, Student student) {
        logger.info("Ready logger");
        TypedQuery<Desktop> query = session.createQuery("select des from Desktop des where des.student = :student", Desktop.class);
        query.setParameter("student", student);

        return query.getSingleResult();
    }

}
