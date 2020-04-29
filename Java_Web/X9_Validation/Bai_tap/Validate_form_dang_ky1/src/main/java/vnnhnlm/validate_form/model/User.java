package vnnhnlm.validate_form.model;




import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.*;



@Entity
@Table(name="user")
public class User  {
    @Id
    @NotEmpty(message = "Tên không được để trống")
    @Size(min=5,max = 45,message = "Tên phải gồm từ 5-45 ký tự")
    @Pattern(regexp ="\\b[A-Z][a-z]*( [A-Z][a-z]*)*\\b",message = "Tên phải viết thường,viết hoa chữ cái đầu,không được nhập số")
    private String firstName;
    @NotEmpty(message = "Họ không được để trống")
    @Size(min=5,max = 45,message = "Họ phải gồm từ 5-45 ký tự")
    @Pattern(regexp ="\\b[A-Z][a-z]*( [A-Z][a-z]*)*\\b",message = "Họ phải viết thường,viết hoa chữ cái đầu,không được nhập số")
    private String lastName;

    @Min(value =18,message = "Tuổi phải lớn hơn 18")
    @Max(value=50,message="Tuổi phải nhỏ hơn 50")
    private int age;

    @NotEmpty(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")

    private String email;

    public User() {
    }

    public User(String firstName, String lastName, int age, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
