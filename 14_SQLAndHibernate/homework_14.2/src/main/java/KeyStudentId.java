import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class KeyStudentId implements Serializable {

    static final long serialVersionUID = 1L;

    @Column(name = "student_name")
    private String studentName;

    public KeyStudentId(String studentName) {
        this.studentName = studentName;
    }

    public KeyStudentId() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyStudentId that = (KeyStudentId) o;
        return Objects.equals(studentName, that.studentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentName);
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
