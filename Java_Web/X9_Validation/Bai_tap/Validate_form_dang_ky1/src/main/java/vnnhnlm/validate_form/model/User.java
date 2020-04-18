package vnnhnlm.validate_form.model;

import org.springframework.stereotype.Component;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User  {
    @NotEmpty
    @Size(min = 2, max = 30)
    private String name;
//    @NotNull(message = "Tên không được để trống")
//    @Size(min=5,max = 45,message = "Họ phải gồm từ 5-45 ký tự")
//    private String lastName;
//
////    @Min(value =18,message = "Tuổi phải lớn hơn 18")
////    @Max(value=50,message="Tuổi phải nhỏ hơn 50")
//    private int age;
//
////    @NotNull(message = "Email không được để trống")
////    @Email(message = "Email không đúng định dạng")
//    private String email;

    public User() {
    }
//
//    public User(String firstName, String lastName, int age, String email) {
//
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
//        this.email = email;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", age=" + age +
//                ", email='" + email + '\'' +
//                '}';
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

}
