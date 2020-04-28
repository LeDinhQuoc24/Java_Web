package casestudy.javaweb.persistence.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
public class Accompany {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "accompany_id")
    private Long id;

    private String name;
    //    @NotEmpty(message = "Giá không được để trống")
    @Min(value=0,message = "Giá phải là số dương lớn hơn 0")
    private long price;
    private String currency;
    private String status;
    @OneToMany(targetEntity = ContractDetail.class,cascade = ALL)
    private List<ContractDetail> contractDetails;

    public Accompany() {
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
