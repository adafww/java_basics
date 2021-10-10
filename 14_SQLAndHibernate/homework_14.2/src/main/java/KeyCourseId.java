import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class KeyCourseId implements Serializable {

    static final long serialVersionUID = 1L;

    @Column(name = "Course_name")
    private String courseName;

    public KeyCourseId(String courseName) {
        this.courseName = courseName;
    }

    public KeyCourseId() {

    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyCourseId that = (KeyCourseId) o;
        return Objects.equals(courseName, that.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName);
    }
}
