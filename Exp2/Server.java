package Exp2;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server{
	public static void main(String[] args) throws Exception{
		ServerSocket ss=new ServerSocket(2001);
        Socket client=ss.accept();
        
        System.out.println("connected with client");
        DataInputStream din = new DataInputStream(client.getInputStream());
        PrintStream dout=new PrintStream(client.getOutputStream());
        
        String clientStr  = din.readLine();
        System.out.println("Received data from client:"+clientStr);
        clientStr = clientStr.trim();
        String array[] = clientStr.split(" ");
        int[] elements = new int[array.length];
		for(int i = 0;i<elements.length;i++) {
			elements[i] = Integer.parseInt(array[i]);
		}
		Arrays.sort(elements);
		String str="";
		for(int i = 0;i<elements.length;i++) {
			str += Integer.toString(elements[i])+" ";
		}
		System.out.println("\ndata sent to client after sorting");
        dout.println(str);
        client.close();
        ss.close();
		
	}
}