package casestudy.javaweb.persistence.entity;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rent_type_id")
    private Long id;

    private String name;
    private long price;

    @OneToMany(targetEntity = Service.class,cascade = ALL)
    @JoinColumn(name="service_id")
    private List<Service> services;

    public RentType(){}

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

    public long getPrice()
    {
        return this.price;
    }

    public void setPrice(long price)
    {
        this.price = price;
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
