package exp4;

import java.util.Scanner;

import exp4.DBOperations;
import exp4.ReadFromCSVFile;

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
int c = db.insertRows(list1);
System.out.println(c + " row insereted");

db.selectQuery1();

}
}