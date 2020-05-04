package vnnhnlm.exam.persistence.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private Long id;
    @NotEmpty(message = "Mã nhân viên không được để trống")
    @Pattern(regexp = "(NV-)[0-9]{4}", message ="Mã nhân viên có định dạng là NV-XXXX (X là số từ 0-9)" )
    private String codeEmployee;
    @NotEmpty(message = "Nhóm nhân viên không được để trống")
    @Pattern(regexp = "[ABC]", message ="Nhóm nhân viên đúng định dạng A/B/C" )
    private String groupEmployee;
    private String fullName;
    private String gender;
    @NotEmpty(message = "Sdt không được để trống")
    @Pattern(regexp = "((090)|(091))[0-9]{7}", message ="Sdt có 10 số,bắt đầu bằng 090/091" )
    private String phoneNumber;
    @ManyToOne(targetEntity = Image.class)
    @JoinColumn(name = "image_id")
    private Image image;
    @NotEmpty(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;
    private String address;
    @Column(name = "id_number")
    @NotEmpty(message = "Chứng minh nhân dân không được để trống")
    @Pattern(regexp = "[0-9]{10}", message ="Chứng minh nhân dân nhập đúng 10 số" )
    private String idNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;



    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeEmployee() {
        return codeEmployee;
    }

    public void setCodeEmployee(String codeEmployee) {
        this.codeEmployee = codeEmployee;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroupEmployee() {
        return groupEmployee;
    }

    public void setGroupEmployee(String groupEmployee) {
        this.groupEmployee = groupEmployee;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
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

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
