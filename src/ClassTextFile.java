import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ClassTextFile {
    private String file1 = "Input.txt";
    ClassTextFile (String file1) {
        try {
            if (!new File(file1).createNewFile())
                System.out.println("File already exists!");
            else
                this.file1 = file1;
        } catch (IOException e) {
        }
    }

    Object setTenantInfo() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader(file1));
        String tenantSecName = sc.nextLine();
        String tenantFirName = sc.nextLine();
        String city = sc.nextLine();
        String street = sc.nextLine();
        int houserNumber = sc.nextInt();
        int appNumber = sc.nextInt();
        return new Object(tenantSecName, tenantFirName, city, street, houserNumber, appNumber);
    }

}
