package casestudy.javaweb.persistence.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contract_id")
    private Long id;

    @Column(name = "contract_number")
    private String contractNumber;
    @Column(name = "begin_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;
    @Column(name = "end_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    private long deposit;
    @Column(name = "total_pay")
    private long totalPay;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(targetEntity = Service.class)
    @JoinColumn(name = "service_id")
    private Service service;

    @OneToMany(targetEntity = ContractDetail.class,cascade = ALL)
    private List<ContractDetail> contractDetails;

    public Contract() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public long getDeposit() {
        return deposit;
    }

    public void setDeposit(long deposit) {
        this.deposit = deposit;
    }

    public long getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(long totalPay) {
        this.totalPay = totalPay;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

}
