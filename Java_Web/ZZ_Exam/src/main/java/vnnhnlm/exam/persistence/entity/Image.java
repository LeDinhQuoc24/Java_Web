package vnnhnlm.exam.persistence.entity;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "image_id")
    private Long id;
    private String name;
    private String image_url;
    private String type;
    @OneToMany(targetEntity = Employee.class,cascade = ALL)
    private List<Employee> employeers;

    public Image() {
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

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Employee> getEmployeers() {
        return employeers;
    }

    public void setEmployeers(List<Employee> employeers) {
        this.employeers = employeers;
    }
}
