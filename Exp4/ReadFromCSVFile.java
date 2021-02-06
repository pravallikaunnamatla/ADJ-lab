package exp4;

import java.io.FileReader;
import java.util.ArrayList;

import au.com.bytecode.opencsv.CSVReader;
import exp4.POJOClass;


public class ReadFromCSVFile {
// TODO Auto-generated method stub

public ArrayList readFromCSV(){


CSVReader reader;

// Declare ArrayList with POJO generic class.
ArrayList<POJOClass> usersList = new ArrayList<POJOClass>();

try{
reader = new CSVReader(new FileReader("./student.csv"));
String[] name = null;
String[] newSt;
while((newSt = reader.readNext())!=null) {
// Declare object from POJO class
POJOClass user = new POJOClass();

// call setter methods for each corresponding column index of CSV file. example in the next comment
// user.setName(newRow[0]);
user.setRegno(newSt[0]);
user.setSGPA(newSt[1]);

// add POJO object into arraylist by calling add() method
usersList.add(user);
}

}
catch(Exception e){
System.out.println(e);
}

return usersList;
}

}
