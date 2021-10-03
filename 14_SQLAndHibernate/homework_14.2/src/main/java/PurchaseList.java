import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "purchaselist")
public class PurchaseList {
    @EmbeddedId
    private KeyPurchaseList id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_name", insertable = false, updatable = false)
    private List<Student> students;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_name", insertable = false, updatable = false)
    @JoinColumn(name = "price", insertable = false, updatable = false)
    private List<Course> courses;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscription_date")
    private List<Subscription> subscriptions;

    public KeyPurchaseList getId() {
        return id;
    }

    public void setId(KeyPurchaseList id) {
        this.id = id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
