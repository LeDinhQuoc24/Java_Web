package casestudy.javaweb.persistence.entity;

import java.util.ArrayList;
import java.util.List;

public class ListLike {
    private List<Service> serviceList;

    public ListLike() {
        //chú ý thêm 1 list Service khi tạo contrustor ListLike
        this.serviceList = new ArrayList<Service>();
    }

    public ListLike(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    public void addListLike(Service service) {
        serviceList.add(service);
    }

    public void removeFromListLike(Long id) {
        for (Service service : serviceList) {
            if (service.getId() == id) {
                serviceList.remove(service);
                return;
            }
        }
    }
}
