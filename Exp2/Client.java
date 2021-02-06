package Exp2;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
public class TCPClient{
	public static void main(String[] args) throws IOException{
		 Socket s=new Socket("localhost",2001);
		 DataInputStream din=new DataInputStream(s.getInputStream());
         PrintStream dout=new PrintStream(s.getOutputStream());  
         
         Scanner scanner=new Scanner(System.in);
         System.out.print("Enter elements separated by space: ");
		 String elementString = scanner.nextLine();
		 dout.println(elementString);
		 System.out.println("Data received");
		 System.out.println("\nElements after sorting:"+din.readLine());
         s.close();
		
	}
}