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

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getOtherConvenienceDescription() {
        return otherConvenienceDescription;
    }

    public void setOtherConvenienceDescription(String otherConvenienceDescription) {
        this.otherConvenienceDescription = otherConvenienceDescription;
    }

    public int getFloorAmount() {
        return floorAmount;
    }

    public void setFloorAmount(int floorAmount) {
        this.floorAmount = floorAmount;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public String getFreeAccompanyService() {
        return freeAccompanyService;
    }

    public void setFreeAccompanyService(String freeAccompanyService) {
        this.freeAccompanyService = freeAccompanyService;
    }
}
