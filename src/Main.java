import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, Exception, FileNotFoundException {
        try {
//          Задание 1
//          Упражнение 1 Исследовать возможности класса File по созданию файлов
//          (пустых) и папок программой. Применение конструктора и метода.
            File file1 = new File("MyFile1.txt");
            file1.createNewFile();
            File file2 = new File("MyFile2.txt");
            file2.createNewFile();
            File file3 = new File("C:\\lab\\MyFile3.txt");
            file3.createNewFile();
            File file4 = new File("C:\\lab\\MyDir1");
            file4.mkdirs();

//          Упражнение 2 Получить параметры файлов методами класса File.
            if (file1.isFile()) {
                System.out.println("File1 является файлом");
            } else {
                System.out.println("File1 не является файлом");
            }
            if (file2.isFile()) {
                System.out.println("File2 является файлом");
            } else {
                System.out.println("File2 не является файлом");
            }
            if (file3.isFile()) {
                System.out.println("File3 является файлом");
            } else {
                System.out.println("File3 не является файлом");
            }

            if (file4.isDirectory()) {
                System.out.println("File4 является каталогом");
            } else {
                System.out.println("File4 не является каталогом");
            }
            System.out.println();

            if (file1.getPath() == "MyFile1.txt"){
                System.out.println("MyFile1.txt находится в корневом каталоге");
            } else {
                System.out.println("MyFile1.txt не находится в корневом каталоге");
            }
            System.out.println();

            System.out.println(file1.getAbsolutePath());
            System.out.println(file2.getAbsolutePath());
            System.out.println(file3.getAbsolutePath());
            System.out.println(file4.getAbsolutePath());
            System.out.println();

            System.out.println("Размер первого файла " + file1.length() + " байт");
            System.out.println("Размер второго файла " + file2.length() + " байт");
            System.out.println("Размер третьего файла " + file3.length() + " байт");
            System.out.println("Размер четвертого файла " + file4.length() + " байт");
            System.out.println();

//          Упражнение 3 Модификация файловой структуры приложения средствами
//          класса File.
            File file5 = new File("C:\\lab\\MyDir2");
            file5.mkdirs();
            File root = new File("C:\\lab");


            String[] array1 = root.list();
            System.out.println("Корневой каталог состоит из:");
            for (String f:array1) {
                System.out.println(f);
            }
            System.out.println();

            File[] array2 = root.listFiles();
            System.out.println("Корневой каталог состоит из:");
            int dirCount = 0;
            for (File f:array2) {
                System.out.println(f.getName());
                if (f.isDirectory()) {
                    dirCount++;
                }
            }            System.out.println();

            System.out.println("В корневом каталоге " + dirCount + " каталогов");

            file1.delete();
            file2.delete();
            file3.delete();
            file4.delete();
            file5.delete();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

//      Задание 2
        int comm0 = -1;
        Scanner sc = new Scanner(System.in);
        while (comm0 != 0) {
            outputMenu();
            comm0 = sc.nextInt();
            System.out.println();
            switch (comm0) {
                case 1:
                    FileControl.addTenant();
                    break;
                case 2:
                    FileControl.outputTenantList();
                    break;
                case 3:
                    FileControl.deleteTenant();
                    break;
                case 4:
                    FileControl.tenantLocation();
                    break;
                case 5:
                    FileControl.checkHousemate();
                    break;
                case 6:
                    FileControl.cityList();
                    break;
                case 0:
                    System.out.println("Завершение программы...");
                    break;
                default:
                    System.out.println("Ошибка, повторите ввод");
            }
        }

//      Задание 3
//      Упражнение 1
        first_step();

//      Упражнение 2
        second_step();

//      Упражнение 3
        third_step();

//      Задание 4
        try {
            String file1path = "C:\\lab\\Serialization.bin";
            File fileS = new File(file1path);
            fileS.createNewFile();
            Scanner fileIn = new Scanner(new FileReader(fileS));
            ClassTextFile input = new ClassTextFile("Input.txt");
            Object one = input.setTenantInfo();
            System.out.println("Информация о жителе: "+one.getTenantSecName()+" "+one.getTenantFirName()+" "+one.getCity()
                    +" "+one.getStreet()+" "+one.getHouseNumber()+" "+one.getAppNumber());
            ObjectSerialization second = new ObjectSerialization("C:\\lab\\Serialization.bin");
            second.outputTenant();
            second.inputTenant();
            ObjectSerialization third = new ObjectSerialization("C:\\lab\\SerializationCol.bin");
            third.addToCollection();
            System.out.println("Коллекция после добавления объектов:");
            third.printCollection();
            third.outputCollection();
            third.inputCollection();
            System.out.println("Коллекция после записи/чтения:");
            third.printCollection();
        } catch (IOException e) {
        }
    }

    private static void outputMenu() {
        System.out.println("Сделайте выбор:");
        System.out.println("1. Добавить жителя в список");
        System.out.println("2. Показать список жителей");
        System.out.println("3. Удалить жителя из списка");
        System.out.println("4. Найти жителя(-ей) по адресу");
        System.out.println("5. Определить, проживает ли по заданному адресу еще один житель");
        System.out.println("6. Найти жителей города");
        System.out.println("0. Выход из программы");

    }


    //  Задание 3
//  Упражнение 1
    public static void first_step() throws IOException {
        File file1 = new File("T1.txt");
        File file2 = new File("T2.txt");
        Reader R = new InputStreamReader(new FileInputStream(file1.getAbsolutePath()));
        Writer W = new OutputStreamWriter(new FileOutputStream(file2.getAbsolutePath(), true));
        int x;
        try {
            while((x = R.read()) != -1){
                W.write((char)x);
            }
        } catch(IOException e) {
        } finally {
            System.out.println("Данные из T1.txt были успешно записаны в T2.txt");
        }
    }

    // Упражнение 2
    public static void second_step() throws IOException {
        File file1 = new File("A.txt");
        file1.createNewFile();
        Writer W = new OutputStreamWriter(new FileOutputStream(file1.getAbsolutePath(), true));
        BufferedReader inb = new BufferedReader(new FileReader(file1.getAbsolutePath()), 128);
        for (int i = 0; i < 512; i++) {
            W.write("k");
        }
        File file2 = new File("B.txt");
        file2.createNewFile();
        BufferedWriter outb = new BufferedWriter(new FileWriter(file2.getAbsolutePath()), 128);
        char[] buf = new char[128];
        for (int i = 0; i < 4; i++) {
            inb.read(buf);
            outb.write(buf);
            if (i != 3) {
                outb.write("\n");
            }
        }
        inb.close();
        outb.close();
        System.out.println("Данные из A.txt были успешно записаны в B.txt");
    }

    // Упражнение 3
        private static void third_step() throws IOException {
            File file1 = new File("A.txt");
            file1.createNewFile();
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file1.getAbsolutePath()),"Cp1251"));
            System.out.println(Charset.defaultCharset().name());
            String line = in.readLine();
            in.close();

            in = new BufferedReader(new InputStreamReader(new FileInputStream(file1.getAbsolutePath()), StandardCharsets.UTF_8));
            line = in.readLine();
            in.close();
            System.out.println(line);
        }

}
