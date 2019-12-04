public class Tenant {
    private String tenantSecName;
    private String tenantFirName;
    private String city;
    private String street;
    private int houseNumber;
    private int appNumber;

    Tenant(String tenantSecName, String tenantFirName, String city, String street, int houseNumber, int appNumber) {
        this.setTenantSecName(tenantSecName);
        this.setTenantFirName(tenantFirName);
        this.setCity(city);
        this.setStreet(street);
        this.setHouseNumber(houseNumber);
        this.setAppNumber(appNumber);
    }

    public String getTenantSecName() {
        return tenantSecName;
    }

    public void setTenantSecName(String tenantSecName) {
        this.tenantSecName = tenantSecName;
    }

    public String getTenantFirName() {
        return tenantFirName;
    }

    public void setTenantFirName(String tenantFirName) {
        this.tenantFirName = tenantFirName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getAppNumber() {
        return appNumber;
    }

    public void setAppNumber(int appNumber) {
        this.appNumber = appNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}


