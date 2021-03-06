import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry =  new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Course course = session.get(Course.class, 5);
        Student student = session.get(Student.class, 51);
        List<Student> studentList = course.getStudents();
        System.out.println(course.getTeacher().getName() + "\n" + "-----------------------------------");
        for(Student student1 : studentList){
            System.out.println(student1.getName());
        }
        System.out.println("-----------------------------------");
        List<Course> courses2 = student.getCourses();
        for(Course course1 : courses2){
            System.out.println(course1.getName());
        }
        System.out.println("-----------------------------------");
        Subscription subscription = session.get(Subscription.class, new Key(student.getId(), course.getId()));
        System.out.println(subscription.getStudent().getName());
        System.out.println(subscription.getCourse().getName());
        System.out.println("-----------------------------------");
        PurchaseList purchaseList = session.get(PurchaseList.class, new KeyPurchaseList(student.getName(), course.getName()));
        System.out.println(purchaseList.getStudentName());
        System.out.println(purchaseList.getCourseName());
        System.out.println(purchaseList.getSubscription());
        System.out.println(purchaseList.getPrice());
        System.out.println("-----------------------------------");
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PurchaseList> query = builder.createQuery(PurchaseList.class);
        Root<PurchaseList> root = query.from(PurchaseList.class);
        query.select(root);
        List<Course> courses = session.createCriteria(Course.class).list();
        List<Student> students = session.createCriteria(Student.class).list();
        List<PurchaseList> purchaseLists = session.createQuery(query).getResultList();
        for (PurchaseList list : purchaseLists){
            Key key = new Key(
                    students.stream().filter(a -> a.getName().equals(list.getStudentName())).toList().get(0).getId(),
                    courses.stream().filter(b -> b.getName().equals(list.getCourseName())).toList().get(0).getId()
            );
            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList(
                    key,
                    list.getPrice(),
                    list.getSubscription()
            );
            session.save(linkedPurchaseList);
        }
        session.getTransaction().commit();
        sessionFactory.close();
    }
}