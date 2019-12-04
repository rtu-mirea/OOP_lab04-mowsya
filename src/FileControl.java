import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileControl {
    public static void addTenant() throws IOException {
        File file1 = new File("TenantList.txt");
        DataOutputStream outT = new DataOutputStream(new FileOutputStream(file1.getAbsolutePath(), true));
        Scanner sc = new Scanner(System.in, "cp1251");
        try {
            System.out.print("Введите фамилию жителя: ");
            outT.writeUTF(sc.nextLine());
            System.out.print("Введите имя жителя: ");
            outT.writeUTF(sc.nextLine());
            System.out.print("Введите название города: ");
            outT.writeUTF(sc.nextLine());
            System.out.print("Введите название улицы: ");
            outT.writeUTF(sc.nextLine());
            System.out.print("Введите номер дома: ");
            outT.writeInt(sc.nextInt());
            System.out.print("Введите номер квартиры: ");
            outT.writeInt(sc.nextInt());

            outT.flush();
            outT.close();
//            DataInputStream inT = new DataInputStream(new FileInputStream(file1.getAbsolutePath()));
//            System.out.println(inT.readUTF() + inT.readUTF() + inT.readUTF() + inT.readUTF() + inT.readInt() + inT.readInt() + inT.readInt() + inT.readInt() + inT.readUTF());

        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void outputTenantList() throws IOException {
        File file1 = new File("TenantList.txt");
        List<Tenant> tenants = new ArrayList<Tenant>();
        DataInputStream inT = new DataInputStream(new FileInputStream(file1.getAbsolutePath()));
        try{
            Tenant current;
            while(true){
                current = new Tenant(inT.readUTF(), inT.readUTF(), inT.readUTF(), inT.readUTF(), inT.readInt(), inT.readInt());
                tenants.add(current);
            }
        } catch(IOException e){
        } finally {
            if (tenants.size() > 0) {
                for (int i = 0; i < tenants.size(); i++) {
                    System.out.println((i + 1) + ". " + tenants.get(i).getTenantSecName());
                }
            }
            inT.close();
        }
    }

    public static void deleteTenant() throws IOException, IndexOutOfBoundsException {
        File file1 = new File("TenantList.txt");
        List<Tenant> tenants = new ArrayList<Tenant>();
        Scanner sc = new Scanner(System.in, "cp1251");
        DataInputStream inT = new DataInputStream(new FileInputStream(file1.getAbsolutePath()));
        System.out.print("Введите номер жителя, которого вы хотите удалить из списка: ");
        int n = sc.nextInt();
        try{
            Tenant current;
            while(true){
                current = new Tenant(inT.readUTF(), inT.readUTF(), inT.readUTF(), inT.readUTF(), inT.readInt(), inT.readInt());
                tenants.add(current);
            }
        } catch(IOException e){
        } finally {
            DataOutputStream outT = new DataOutputStream(new FileOutputStream(file1.getAbsolutePath()));
            tenants.remove(n - 1);
            for (int i = 0; i < tenants.size(); i++) {
                outT.writeUTF(tenants.get(i).getTenantSecName());
                outT.writeUTF(tenants.get(i).getTenantFirName());
                outT.writeUTF(tenants.get(i).getCity());
                outT.writeUTF(tenants.get(i).getStreet());
                outT.writeInt(tenants.get(i).getHouseNumber());
                outT.writeInt(tenants.get(i).getAppNumber());
            }
            System.out.println("Житель удален");
            outT.flush();
            outT.close();
            inT.close();
        }
    }

    public static void tenantLocation() throws IOException {
        File file1 = new File("TenantList.txt");
        List<Tenant> tenants = new ArrayList<Tenant>();
        DataInputStream inT = new DataInputStream(new FileInputStream(file1.getAbsolutePath()));
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.println("Введите название города: ");
        String city = sc.nextLine();
        System.out.println("Введите название улицы: ");
        String street = sc.nextLine();
        System.out.println("Введите номер дома: ");
        int house = sc.nextInt();
        System.out.println("Введите номер квартиры: ");
        int app = sc.nextInt();
        try{
            Tenant current;
            while(true){
                current = new Tenant(inT.readUTF(), inT.readUTF(), inT.readUTF(), inT.readUTF(), inT.readInt(), inT.readInt());
                tenants.add(current);
            }
        } catch(IOException e){
        } finally {
            if (tenants.size() > 0) {
                System.out.println("Житель(-и) по заданному адресу:");
                for (int i = 0; i < tenants.size(); i++) {
                    Tenant tenant = tenants.get(i);
                    if (tenant.getCity().equals(city) && tenant.getAppNumber() == app && tenant.getHouseNumber() == house && tenant.getStreet().equals(street)) {
                        System.out.println((i+1) + ". " + tenant.getTenantSecName()+" "+tenant.getTenantFirName());
                    }
                }
            }
            inT.close();
        }
    }

   public static void checkHousemate() throws IOException {
       File file1 = new File("TenantList.txt");
       List<Tenant> tenants = new ArrayList<Tenant>();
       DataInputStream inT = new DataInputStream(new FileInputStream(file1.getAbsolutePath()));
       Scanner sc = new Scanner(System.in, "cp1251");
       System.out.println("Введите название города: ");
       String city = sc.nextLine();
       System.out.println("Введите название улицы: ");
       String street = sc.nextLine();
       System.out.println("Введите номер дома: ");
       int house = sc.nextInt();
       System.out.println("Введите номер квартиры: ");
       int app = sc.nextInt();
       try{
           Tenant current;
           while(true){
               current = new Tenant(inT.readUTF(), inT.readUTF(), inT.readUTF(), inT.readUTF(), inT.readInt(), inT.readInt());
               tenants.add(current);
           }
       } catch(IOException e){
       } finally {
           int count = 0;
           if (tenants.size() > 0) {
               for (int i = 0; i < tenants.size(); i++) {
                   Tenant tenant = tenants.get(i);
                   if (tenant.getCity().equals(city) && tenant.getAppNumber() == app && tenant.getHouseNumber() == house && tenant.getStreet().equals(street)) {
                       count++;
                       if (count > 1){
                           System.out.println("По данному адресу проживает больше 1 жителя");
                           return;
                       }
                   }
               }
           }
           if (count == 1){
               System.out.println("По данному адресу проживает один житель");
           } else{
               System.out.println("По данному адресу никто не живет");
           }
           inT.close();
       }
    }

    public static void cityList() throws IOException {
        File file1 = new File("TenantList.txt");
        List<Tenant> tenants = new ArrayList<Tenant>();
        DataInputStream inT = new DataInputStream(new FileInputStream(file1.getAbsolutePath()));
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.print("Введите название города: ");
        String target = sc.nextLine();
        try{
            Tenant current;
            while(true){
                current = new Tenant(inT.readUTF(), inT.readUTF(), inT.readUTF(), inT.readUTF(), inT.readInt(), inT.readInt());
                tenants.add(current);
            }
        } catch(IOException e){
        } finally {
            List<Tenant> city = new ArrayList<Tenant>();
            for (int i = 0; i < tenants.size(); i++) {
                if (tenants.get(i).getCity().equals(target)) {
                    city.add(tenants.get(i));
                }
            }
            System.out.println("Жители выбранного города: ");
            for (int i = 0; i < city.size(); i++) {
                System.out.println((i + 1) + ". " + city.get(i).getTenantSecName() + " " + city.get(i).getTenantFirName());
            }
            inT.close();
        }
    }

}
