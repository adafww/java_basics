import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchaselist")
public class PurchaseList {

    @EmbeddedId
    private KeyPurchaseList id;
    //@ManyToOne(cascade = CascadeType.ALL)
    //@MapsId("studentName")
    //@JoinColumn(name = "student_name", insertable = false, updatable = false)
    //private Student student;

    //@ManyToOne(cascade = CascadeType.ALL)
    //@MapsId("courseName")
    //@JoinColumn(name = "course_name", insertable = false, updatable = false)
    //private Course course;
    @Column(name = "student_name", insertable = false, updatable = false)
    private String studentName;
    @Column(name = "course_name", insertable = false, updatable = false)
    private String courseName;
    private int price;
    @Column(name = "subscription_date")
    private Date subscription;

    public KeyPurchaseList getId() {
        return id;
    }

    public void setId(KeyPurchaseList id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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
}
