import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * write
 */

public class write {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        try {
            RandomAccessFile raf = new RandomAccessFile("data.dat", "rw");
            WriteToFile wtf = new WriteToFile();
            int in;
            wtf.write(raf, new Employee(5, "fname", "lname", 100.0));
            wtf.write(raf, new Employee(2, "fname", "lname", 200.0));
            wtf.write(raf, new Employee(1, "Pawel", "Wodyk", 300.0));

            do {
                in = sc.nextInt();
                try {
                    raf.seek(in);
                    System.out.println("=>" + raf.read());
                    System.out.println("=>" + raf.read());
                    System.out.println("=>" + raf.read());
                    System.out.println("=>" + raf.read());
                } catch (Exception e) {
                    // TODO: handle exception
                    System.err.println("27:=>" + e.toString());
                }
            } while (in != -1);
            raf.seek(0);
            System.out.println(raf.readInt());
            raf.seek(32);
            System.out.println(raf.readInt());
            raf.seek(64);
            System.out.println(raf.readInt());
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("38:=>" + e.toString());
        }

        System.out.println("End of program");

        sc.close();
    }

}

class WriteToFile {

    public void write(RandomAccessFile raf, Employee emp) {
        try {
            System.out.println(emp.id instanceof Integer);
            System.out.println(emp.fname instanceof String);
            System.out.println(emp.lname instanceof String);
            System.out.println(emp.pay instanceof Double);
            raf.writeInt(emp.id);
            raf.writeChars(emp.fname);
            raf.writeChars(emp.lname);
            raf.writeDouble(emp.pay);
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("62:=>" + e.toString());
        }
    }
}

class Employee {
    String fname, lname;
    Integer id;
    Double pay;

    Employee(Integer id, String fname, String lname, Double pay) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.pay = pay;
    }

}