import java.util.ArrayList;
import java.util.List;

public class Info_Data {
    private static final List<Customer>
            listCustomer = new ArrayList<Customer>();
    static {
        initData();
    }
    private static void initData() {
        Customer cus1 = new Customer("Trần Ngoc Tân", "Đà Nẵng", "img/tan.jpg", "02/02/1998");
        Customer cus2 = new Customer("Phạm Minh Hưng", "Quảng Nam", "img/hung.png", "03/02/1997");
        Customer cus3 = new Customer("Nguyễn Đình Hòa", "Quảng Nam", "img/hoa.png", "02/08/1994");
        Customer cus4 = new Customer("Lê Đình Quốc", "Quảng Nam", "img/quoc.jpg", "11/06/1998");
        Customer cus5 = new Customer("Phạm Thái Cường", "Nha Trang", "img/cuong.png", "09/02/1996");
        listCustomer.add(cus1);
        listCustomer.add(cus2);
        listCustomer.add(cus3);
        listCustomer.add(cus4);
        listCustomer.add(cus5);

    }
    // Truy vấn bảng Department.
    public static List<Customer> queryCustomers() {
        return listCustomer;
    }

}
