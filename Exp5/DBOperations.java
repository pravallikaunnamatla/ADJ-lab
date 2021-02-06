package exp5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import exp5.POJOClass;

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

/*public int insertRows(ArrayList list){
int rows=0;
try{
Connection con = getDBConnection();
//create insert query relevent to your application with ? instead of values
String query="insert into grade values(?,?)";

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
}*/

public void selectQuery(String sgpa) {

// Parameter list as per your requirement to set the values into select query
try{
// prepare select query relevant to your requirement with ? .
for(int i=0; i<= 10; i++) {
String query="update grade set SGPA = ? where SGPA = '-' ";
Connection con=getDBConnection();
PreparedStatement psmt=con.prepareStatement(query);

// call psmt.setXXX() methods to set the values into all ? in query.
psmt.setString(1,sgpa);
// execute query
ResultSet rs=psmt.executeQuery();

// Iterate rs to show results of query
while(rs.next()) {
System.out.println(rs.getString(1));
}

closeDBConnection(con);
}
}
catch(Exception e){
e.printStackTrace();
}
}
}
