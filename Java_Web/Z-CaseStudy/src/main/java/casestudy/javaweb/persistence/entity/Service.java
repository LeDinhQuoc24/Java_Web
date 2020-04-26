package casestudy.javaweb.persistence.entity;

import javax.persistence.*;


@Entity
public  class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="service_id")
    private Long id;
    @Column(name="service_name")
    private String name;
    @Column(name="areaUsed")
    private double areaUsed;
    @Column(name="amount")
    private int amount;
    @Column(name = "maximum_people")
    private int maximumPeople;

    @ManyToOne(targetEntity = RentType.class)
    @JoinColumn(name = "rent_type_id")
    private RentType rentType;

    @ManyToOne(targetEntity = ServiceType.class)
    @JoinColumn(name = "service_type_id")
    private ServiceType serviceType;



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

}
