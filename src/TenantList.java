import java.util.ArrayList;
import java.util.Scanner;

public class TenantList {
    private ArrayList<Tenant> tenants;

    TenantList() {
        tenants = new ArrayList<Tenant>();
    }

    public void addTenant() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите фамилию жильца: ");
        String secname = sc.nextLine();
        System.out.print("Введите имя жильца: ");
        String firname = sc.nextLine();
        System.out.print("Введите название города: ");
        String city = sc.nextLine();
        System.out.print("Введите название улицы: ");
        String street = sc.nextLine();
        System.out.print("Введите номер дома: ");
        int home = sc.nextInt();
        System.out.print("Введите номер квартиры: ");
        int app = sc.nextInt();
        tenants.add(new Tenant(secname, firname, city, street, home, app));
    }
}
