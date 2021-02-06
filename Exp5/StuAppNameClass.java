package exp5;

import java.util.Scanner;

import exp5.DBOperations;
import exp5.ReadFromCSVFile;

import java.util.ArrayList;

public class StuAppNameClass {

public static void main(String[] args) {
// TODO Auto-generated method stub

// Create readfromcsvfile object
ReadFromCSVFile rfc=new ReadFromCSVFile();

// call readfromcsvfile() and get arraylist object
ArrayList list1=rfc.readFromCSV();

// create object from dboperation object
DBOperations db=new DBOperations();

// call insertRows() by passing arraylist object and get integer and display no of rows inserted done.
/*int c = db.insertRows(list1);
System.out.println(c + " row insereted"); */

//db.selectQuery1();

//ArrayList supply = new ArrayList();
Scanner sc = new Scanner(System.in);
System.out.println("Enter the supplymentary marks");
//for(int i=0; i<10; i++) {
String sgpa = sc.nextLine();
//supply.add(sgpa);
//}
db.selectQuery(sgpa);

}
}



module exp5 {
requires opencsv;
requires java.sql;
}