package vnnhnlm.validate_form.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Component
@Entity
@Table(name="user")
public class User implements Validator {
    @Id
    private String firstName;
    private String lastName;
    private int age;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }
//    supports là phương thức xác định class này được Validate

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        //Validated FirstName
        String firstName = user.getFirstName();
        ValidationUtils.rejectIfEmpty(errors, "firstName", "firstName.empty");
        if (firstName.length()>45 || firstName.length()<5){
            errors.rejectValue("firstName", "firstName.length");
        }
        if (!firstName.startsWith("Q")){
            errors.rejectValue("firstName", "firstName.startsWith");
        }
        if (!firstName.matches("(^$|[a-zA-Z ]*$)")){
            errors.rejectValue("firstName", "firstName.matches");
        }
        //Validated LastName
        String lastName = user.getLastName();
        ValidationUtils.rejectIfEmpty(errors, "lastName", "lastName.empty");
        if (lastName.length()>45 || lastName.length()<5){
            errors.rejectValue("lastName", "lastName.length");
        }
        if (!firstName.startsWith("Q")){
            errors.rejectValue("lastName", "lastName.startsWith");
        }
        if (!firstName.matches("(^$|[a-zA-Z ]*$)")){
            errors.rejectValue("lastName", "lastName.matches");
        }
//        if (!firstName.matches("(^[0-9]{1,3}$)")){
//            errors.rejectValue("age", "age.matches");
//        }
        //Validated age
        int age = user.getAge();
        ValidationUtils.rejectIfEmpty(errors, "age", "age.empty");
        if (age>100 || age<5){
            errors.rejectValue("age", "age.value");
        }
//        if (!(age.matches("(^$|[a-zA-Z ]*$)")){
//            errors.rejectValue("age", "age.matches");
//        }


        //Validated email
        String email = user.getEmail();
        ValidationUtils.rejectIfEmpty(errors, "email", "email.empty");
        if (email.length()>45 || email.length()<5){
            errors.rejectValue("email", "email.length");
        }
    }
}
