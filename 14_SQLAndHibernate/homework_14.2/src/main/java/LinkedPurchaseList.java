import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList {
    @EmbeddedId
    private KeyLinkedPurchaseList id;

    @Column(name = "student_name", insertable = false, updatable = false)
    private String studentName;

    @Column(name = "course_name", insertable = false, updatable = false)
    private String courseName;
    private int price;
    @Column(name = "subscription_date")
    private Date subscription;

    public LinkedPurchaseList(KeyLinkedPurchaseList id, int price, Date subscription) {
        this.id = id;
        this.price = price;
        this.subscription = subscription;
    }

    public LinkedPurchaseList() {

    }

    public KeyLinkedPurchaseList getId() {
        return id;
    }

    public void setId(KeyLinkedPurchaseList id) {
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
