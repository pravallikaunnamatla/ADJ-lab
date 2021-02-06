package exp4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import exp4.POJOClass;

public class DBOperations {

public Connection getDBConnection(){
Connection con=null;
try {
// load the jdbc driver-4 into application for mysql.
Class.forName("com.mysql.jdbc.Driver");

//establish the connection.
// DriverManager.getConnection(connectionURL, username,password)

con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "");
}
catch(Exception e){
e.printStackTrace();
}

return con;
}

public void closeDBConnection(Connection con){
try{
    con.close();
}catch(Exception e){
      e.printStackTrace();
}
}

public int insertRows(ArrayList list){
int rows=0;
try{
Connection con = getDBConnection();
//create insert query relevent to your application with ? instead of values
String query="insert into Stu_grade values(?,?)";

PreparedStatement psmt=con.prepareStatement(query);

// Create object of Iterator from ArrayList and then iterate through

Iterator<POJOClass> it=list.iterator();

while(it.hasNext()){
// Create POJO object from it.next
POJOClass object=it.next();
// call setXXX() methods to set the values with the values of POJO class members by calling its getter in place of each ?

psmt.setString(1,object.getRegno());
psmt.setString(2,object.getSGPA());

rows=psmt.executeUpdate();
}
closeDBConnection(con);
}
catch(Exception e){
e.printStackTrace();
}

return rows;
}

public void selectQuery1() {
// Parameter list as per your requirement to set the values into select query
try{
// prepare select query relevant to your requirement with ? .
String n = "select count(*) from student_grade";
//String query= "select (count(SGPA) / 60)  * 100  from student_grade where SGPA = '-' ";

Connection con=getDBConnection();

PreparedStatement psmt1=con.prepareStatement(n);
ResultSet rs1 = psmt1.executeQuery();
String m = rs1.getString(1);
while(rs1.next()) {
System.out.println(m);
}

/*PreparedStatement psmt=con.prepareStatement(query);
//psmt.setString(1,);
ResultSet rs=psmt.executeQuery();
while(rs.next()) {
System.out.println(rs.getString(1));
}
*/
closeDBConnection(con);
}
catch(Exception e){
e.printStackTrace();
}

}
}

package exp4;

public class POJOClass {

//Declare variables which are matched with CSV columns.

    String Regno;
    String SGPA;
   
    // Add getters and setters methods
   
public String getRegno() {
return Regno;
}
public void setRegno(String regno) {
Regno = regno;
}
public String getSGPA() {
return SGPA;
}
public void setSGPA(String sGPA) {
SGPA = sGPA;
}

}