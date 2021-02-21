package hibernate.demo.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "Student")
@NamedQueries(
    @NamedQuery(
        name = "findStudentByName",
        query = "select p from Student p where p.name = :name"
    )
)
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private int age;

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Student student = (Student) o;
        return id == student.id && age == student.age && Objects.equal(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, age);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("id", id)
                          .add("name", name)
                          .add("age", age)
                          .toString();
    }
}
