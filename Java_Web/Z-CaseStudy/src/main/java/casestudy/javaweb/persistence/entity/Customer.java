package casestudy.javaweb.persistence.entity;



import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private Long id;


    @NotEmpty(message = "Mã khách hàng không được để trống")
    @Pattern(regexp = "(KH-)[0-9]{4}", message ="Mã Khách hàng có định dạng là KH-XXXX (X là số từ 0-9)" )
    private String codeCustomer;

    @Column(name = "full_name")
    private String fullName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @Pattern(regexp = "((0)[1-9]|[1-2][0-9]|(3)[0-1])(/)((0)[1-9]|(1)[0-2])(/)((19)|(20))([0-2]{2})",
//            message ="Nhập đúng định dạng ngày tháng năm sinh" )
    private Date birth;
    private String gender;

    @Column(name = "id_number")
    @NotEmpty(message = "Chứng minh nhân dân không được để trống")
    @Pattern(regexp = "[0-9]{9}", message ="Chứng minh nhân dân nhập đúng 9 số" )
    private String idNumber;


    @Column(name = "phone_number")
    @NotEmpty(message = "Sdt không được để trống")
    @Pattern(regexp = "((090)|(091))[0-9]{7}", message ="Sdt có 10 số,bắt đầu bằng 090/091" )
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

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
    }
}
