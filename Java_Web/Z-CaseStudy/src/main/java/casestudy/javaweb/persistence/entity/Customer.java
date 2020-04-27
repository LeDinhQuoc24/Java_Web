package casestudy.javaweb.persistence.entity;



import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "full_name")
    private String fullName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    private String gender;
    @Column(name = "id_number")
    private String idNumber;
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotEmpty(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;private String address;

    @ManyToOne(targetEntity = CustomerType.class)
    @JoinColumn(name = "customer_type_id")
    private CustomerType customerType;

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @ManyToOne(targetEntity =Image.class)
    @JoinColumn(name = "image_id")
    private Image image;

    private String status = "NotRegistered";

    @OneToMany(targetEntity = Contract.class,cascade = ALL)
    @JoinColumn(name="contract_id")
    private List<Contract> contracts;


    public Customer() {

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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



    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
