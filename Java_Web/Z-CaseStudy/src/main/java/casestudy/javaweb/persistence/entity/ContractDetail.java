package casestudy.javaweb.persistence.entity;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_detail_id")
    private Long id;

    private int quantity;
    @ManyToOne(targetEntity = Contract.class)
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
