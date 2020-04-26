package casestudy.javaweb.persistence.entity;

import javax.persistence.*;
import java.util.List;
@Entity
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id")
    private Long id;

    private String name;

    @OneToMany(targetEntity = Service.class)
    private List<Service> services;

    public ServiceType(){}

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Service> getServices()
    {
        return this.services;
    }

    public void setServices(List<Service> services)
    {
        this.services = services;
    }
}
