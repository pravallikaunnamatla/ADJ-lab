import java.rmi.*;
import java.util.*;

public class RMIClient {
public static void main(String args[]) throws Exception{

float p,t,r,n,si,ci;

Scanner sc=new Scanner(System.in);
System.out.println("Enter Principle Amount :");
p=sc.nextFloat();
System.out.println("Enter Time :");
t=sc.nextFloat();
System.out.println("Enter Interest Rate :");
r=sc.nextFloat();
System.out.println("Enter number of times that interest is compounded per unit :");
n=sc.nextFloat();

Interest i=(Interest)Naming.lookup("rmi://localhost:2001/interestServer");

si=i.simple(p,t,r);
ci=i.compound(p,t,r,n);

System.out.println("Simple Interest :"+si+"\nCompound Interest :"+ci);



}
}