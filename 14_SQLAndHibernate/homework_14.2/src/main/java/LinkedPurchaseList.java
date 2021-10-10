import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList {
    @EmbeddedId
    private Key id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student studentId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course courseId;
    private Integer price;
    @Column(name = "subscription_date")
    private Date subscription;

    public LinkedPurchaseList(Key id, Integer price, Date subscription) {
        this.id = id;
        this.price = price;
        this.subscription = subscription;
    }

    public Key getId() {
        return id;
    }

    public void setId(Key id) {
        this.id = id;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscription() {
        return subscription;
    }

    public void setSubscription(Date subscription) {
        this.subscription = subscription;
    }

    public LinkedPurchaseList(Key id, int price, Date subscription) {
        this.id = id;
        this.price = price;
        this.subscription = subscription;
    }

    public LinkedPurchaseList() {

    }
}