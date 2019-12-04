import java.util.Scanner;

public class Object {
    private String tenantSecName;
    private String tenantFirName;
    private String city;
    private String street;
    private int houseNumber;
    private int appNumber;
    private Scanner sc = new Scanner(System.in);

    Object() {
    }

    Object(String tenantSecName, String tenantFirName, String city, String street, int houseNumber, int appNumber) {
        this.tenantSecName = tenantSecName;
        this.tenantFirName = tenantFirName;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.appNumber = appNumber;
    }

    public void setTenantSecName() {
        System.out.print("Введите фамилию жителя: ");
        this.tenantSecName = sc.nextLine();
    }

    public void setHouseNumber() {
        System.out.print("Введите номер дома: ");
        this.houseNumber = sc.nextInt();
        sc.nextLine();
    }

    public void setStreet() {
        System.out.print("Введите название улицы: ");
        this.street = sc.nextLine();
    }

    public void setAppNumber() {
        System.out.print("Введите номер квартиры: ");
        this.appNumber = sc.nextInt();
        sc.nextLine();
    }

    public void setTenantFirName() {
        System.out.print("Введите имя жителя: ");
        this.tenantFirName = sc.nextLine();
    }

    public void setCity() {
        System.out.print("Введите название города: ");
        this.city = sc.nextLine();
    }

    public String getTenantSecName() {
        return tenantSecName;
    }

    public String getStreet() {
        return street;
    }

    public String getTenantFirName() {
        return tenantFirName;
    }

    public String getCity() {
        return city;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getAppNumber() {
        return appNumber;
    }

}
