import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ObjectSerialization {
    String file1 = "C:\\lab\\Serialization.bin";
    String file2 = "C:\\lab\\SerializationCol.bin";
    private ArrayList<Object> tenants = new ArrayList<Object>();

    ObjectSerialization(String file1) throws IOException {
        try {
            if (!new File(file1).createNewFile()) {
                System.out.println("Файл уже существует!");
            } else {
                this.file1 = file1;
            }
        } catch(IOException e) {}
    }

    public void outputTenant() throws IOException {
        Object output = new Object();
        output.setTenantSecName();
        output.setTenantFirName();
        output.setCity();
        output.setStreet();
        output.setHouseNumber();
        output.setAppNumber();

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file1));
        out.writeUTF(output.getTenantSecName());
        out.writeUTF(output.getTenantFirName());
        out.writeUTF(output.getCity());
        out.writeUTF(output.getStreet());
        out.writeInt(output.getHouseNumber());
        out.writeInt(output.getAppNumber());

        out.close();
    }

    void inputTenant () throws IOException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file1));

        Object input = new Object(in.readUTF(), in.readUTF(), in.readUTF(), in.readUTF(), in.readInt(), in.readInt());

        System.out.println("Информация: "+input.getTenantSecName()+" "+input.getTenantFirName()+" "+input.getCity()
                +" "+input.getStreet()+" "+input.getHouseNumber()+" "+input.getAppNumber());
        in.close();
    }

    public void addToCollection() {
        Scanner in = new Scanner(System.in);
        System.out.println("Сколько жителей вы хотите добавить?");
        int num = in.nextInt();
        for (int i = 0; i < num; i++) {
            Object t = new Object();
            t.setTenantSecName();
            t.setTenantFirName();
            t.setCity();
            t.setStreet();
            t.setHouseNumber();
            t.setAppNumber();
            tenants.add(t);
        }
    }

    public void outputCollection() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file2));
        for (Object t: tenants) {
            out.writeUTF(t.getTenantSecName());
            out.writeUTF(t.getTenantFirName());
            out.writeUTF(t.getCity());
            out.writeUTF(t.getStreet());
            out.writeInt(t.getHouseNumber());
            out.writeInt(t.getAppNumber());
        }

        out.close();
    }

    void inputCollection() throws IOException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file2));

        tenants.clear();
        while(true) {
            try {
                tenants.add(new Object(in.readUTF(), in.readUTF(), in.readUTF(), in.readUTF(), in.readInt(), in.readInt()));
            } catch (EOFException e) {
                in.close();
                break;
            }
        }
    }

    void printCollection() {
        for (Object t : tenants) {
            System.out.println(t.getTenantSecName()+" "+t.getTenantFirName()+" "+t.getCity()
                    +" "+t.getStreet()+" "+t.getHouseNumber()+" "+t.getAppNumber());
        }
    }

    ObjectSerialization getObject() {
        return this;
    }

    ArrayList<Object> getCollection() {
        return tenants;
    }
}
