package casestudy.javaweb.persistence.entity;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

//Trinh do
@Entity
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "degree_id")
    private Long id;
    private String name;
    @OneToMany(targetEntity = Employee.class,cascade = ALL)
    private List<Employee> employees;
    public Degree() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
