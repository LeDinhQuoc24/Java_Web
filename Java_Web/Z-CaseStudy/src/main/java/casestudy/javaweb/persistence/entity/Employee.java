package casestudy.javaweb.persistence.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    private Date birth;
    @Column(name = "id_number")
    private String idNumber;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;
    private String address;
    private long salary;
    @ManyToOne(targetEntity = Degree.class)
    @JoinColumn(name = "degree_id")
    private Degree degree;
    @ManyToOne(targetEntity = Position.class)
    @JoinColumn(name = "position_id")
    private Position position;
    @ManyToOne(targetEntity = Part.class)
    @JoinColumn(name="part_id")
    private Part part;
    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
