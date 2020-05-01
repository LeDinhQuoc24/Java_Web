package casestudy.javaweb.persistence.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

import static javax.persistence.CascadeType.ALL;


@Entity
public  class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="service_id")
    private Long id;

    @NotEmpty(message = "Mã dịch vụ không được để trống")
    @Pattern(regexp = "(DV-)[0-9]{4}", message ="Mã dịch vụ có định dạng là DV-XXXX (X là số 0-9)" )
    private String codeService;

    @Column(name="service_name")
    private String name;

    @Column(name="areaUsed")
//    @NotEmpty(message = "Diện tích không được để trống")
    @Min(value=0,message = "Diện tích phải là số dương lớn hơn 0")
    private double areaUsed;
    @Column(name="amount")
//    @NotEmpty(message = "Chi phí thuê không được để trống")
    @Min(value=0,message = "Chi phí thuê phải là số dương lớn hơn 0")
    private int amount;
    @Column(name = "maximum_people")
//    @NotEmpty(message = "Số người tối đa không được để trống")
    @Min(value=0,message = "Số người tối đa phải là số dương lớn hơn 0")
    private int maximumPeople;

    @Column(name = "typeRent")
    private String typeRent;
    @Column(name="typeService")
    private String typeService;



    //Villa/House
    private String roomStandard;
    //Villa/House
    private String otherConvenienceDescription;
    //Villa/House
    private int floorAmount;
    //Villa
    private double poolArea;
    //Room
    private String freeAccompanyService;


    @ManyToOne(targetEntity = RentType.class)
    @JoinColumn(name = "rent_type_id")
    private RentType rentType;

    @ManyToOne(targetEntity = ServiceType.class)
    @JoinColumn(name = "service_type_id")
    private ServiceType serviceType;

    @OneToMany(targetEntity = Contract.class,cascade = ALL)
    @JoinColumn(name="contract_id")
    private List<Contract> contracts;

    private String status = "NotRegistered";
    private String status2 = "black";




    public Service() {
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

    public double getAreaUsed() {
        return areaUsed;
    }

    public void setAreaUsed(double areaUsed) {
        this.areaUsed = areaUsed;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getMaximumPeople() {
        return maximumPeople;
    }

    public void setMaximumPeople(int maximumPeople) {
        this.maximumPeople = maximumPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public String getCodeService() {
        return codeService;
    }

    public void setCodeService(String codeService) {
        this.codeService = codeService;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        this.typeRent = typeRent;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    public String getStatus2() {
        return status2;
    }

    public void setStatus2(String status2) {
        this.status2 = status2;
    }
}
