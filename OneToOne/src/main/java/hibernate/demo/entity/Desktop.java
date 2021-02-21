package hibernate.demo.entity;

import com.google.common.base.Objects;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Desktop")
public class Desktop implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false, unique = true)
    private Student student;

    @Column
    private int deskNo;

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Desktop desktop = (Desktop) o;
        return id == desktop.id && deskNo == desktop.deskNo && Objects.equal(student, desktop.student);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, student, deskNo);
    }

}
