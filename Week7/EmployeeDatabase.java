import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Database
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  04/03/19
 * Description:
 * 	    Class responsible for handing the employee database, 
 *      ensures the data is entered correctlly and enough space is ensured for the first and last name
 * 
 *      To modiffy the size of the name field edit nameLength and modify the recordSize as approprate
 *      
 *      Default size of file 100 records, defaulting to 9200 Bytes, aprox 8.98 KB
 * 
 *      Class used by L7EmployeeWriteFile, L7EmployeeReadFile, EmployeeDatabase
 *      Use Class Employee
 */

public class EmployeeDatabase {
    private File file;
    private RandomAccessFile raf;
    private final int nameLength = 20;
    private final int recordSize = 92;
    private int numOfRecords;

    public EmployeeDatabase() throws IOException {
        this(100);
    }

    public EmployeeDatabase(int size) throws IOException {
        file = new File("data.dat");
        raf = new RandomAccessFile(file, "rw");
        numOfRecords = size * recordSize;
        raf.setLength(numOfRecords);
    }

    public int getRecordSize() {
        return recordSize;
    }

    public long getFileSize() {
        try {
            return raf.length();
        } catch (IOException ioEx) {
            System.err.println("Error: Could not get the size of the file :=> " + ioEx.toString());
            return 0;
        }

    }

    public void wipeFile() throws IOException {
        raf.seek(0);
        for (int i = 0; i < raf.length(); i++) {
            raf.write(0);
        }
    }

    public int writeToFile(Employee emp) {
        StringBuilder fnameBuilder = new StringBuilder(nameLength);
        StringBuilder lnameBuilder = new StringBuilder(nameLength);

        fnameBuilder.insert(0, emp.getEmpFname());
        fnameBuilder.setLength(nameLength);

        lnameBuilder.insert(0, emp.getEmpLname());
        lnameBuilder.setLength(nameLength);

        if (emp.getEmpID() > 0 && emp.getEmpID() <= numOfRecords) {
            try {

                raf.seek((emp.getEmpID() - 1) * recordSize);
                System.out.println("***Writing to Employee File:***");
                System.out.print(emp.getEmpID() + "|");
                raf.writeInt(emp.getEmpID());

                System.out.print(fnameBuilder.toString() + "|");
                raf.writeChars(fnameBuilder.toString());

                System.out.print(lnameBuilder.toString() + "|");
                raf.writeChars(lnameBuilder.toString());

                System.out.println(emp.getEmpPay() + "|");
                raf.writeDouble(emp.getEmpPay());

                System.out.println(emp.toString());
            } catch (Exception e) {
                System.out.println("Error while writing Employee" + e.toString());
                return 0;
            }
            return 1;
        } else {
            return 0;
        }
    }

    public Employee readFromFile(int queryId) {
        int id = queryId;
        char[] fname = new char[nameLength];
        char[] lname = new char[nameLength];
        double pay = 0.0;
        if (id > 0 && id <= numOfRecords) {
            try {
                raf.seek((queryId - 1) * recordSize);
                id = raf.readInt();
                for (int i = 0; i < fname.length; i++) {
                    fname[i] = raf.readChar();
                }
                for (int i = 0; i < lname.length; i++) {
                    lname[i] = raf.readChar();
                }
                pay = raf.readDouble();

            } catch (Exception e) {
                System.out.println("Error while retriving Employee" + e.toString());
            }
        }
        return new Employee(id, new String(fname), new String(lname), pay);

    }

    public String fileToString() throws IOException {
        String output = "Bytes: ";
        int read, i = 0;
        raf.seek(0);
        while ((read = raf.read()) != -1) {
            if (i % getRecordSize() == 0) {
                output += "|\nRecord:" + ((i / getRecordSize()) + 1) + "=>|";
            }
            if (i % 2 == 0) {
                output += " ";
            }
            output += read + " ";
            i++;
        }
        output += "\nLength: " + raf.length();
        return output;
    }

    public void closeConnection() {
        try {
            //System.out.println(fileToString());
            raf.close();
            System.out.println("Connection closed...");
        } catch (IOException ioEx) {
            System.err.print("Could not close the Random Access File connection :=> " + ioEx.toString());
        }

    }

}