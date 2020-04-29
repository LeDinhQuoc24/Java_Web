package casestudy.javaweb.persistence.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;

import static javax.persistence.CascadeType.ALL;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_detail_id")
    private Long id;
    //    @NotEmpty(message = "Số lượng không được để trống")
    @Min(value=0,message = "Số lượng phải là số dương lớn hơn 0")
    private int quantity;
    @OneToOne(targetEntity = Contract.class,cascade = ALL)
    @JoinColumn(name="contract_id")
    private Contract contract;

    @ManyToOne(targetEntity = Accompany.class)
    @JoinColumn(name = "accompany_id")
    private Accompany accompany;

    public ContractDetail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Accompany getAccompany() {
        return accompany;
    }

    public void setAccompany(Accompany accompany) {
        this.accompany = accompany;
    }

}
