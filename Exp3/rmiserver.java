import java.rmi.*;
import java.rmi.server.*;


public class RMIServer extends UnicastRemoteObject implements Interest{

public RMIServer() throws RemoteException{
super();
}

public float simple(float p,float t,float r) throws RemoteException{
return (p*t*r)/100;
}
public float compound(float p,float t,float r,float n) throws RemoteException{
float x,y,x1,i;
x=1+(r/n);
y=n*t;
x1=x;
for(i=1;i<y;i++){
x=x*x1;
}

return p*x;
}

public static void main(String args[]) throws Exception{
RMIServer server =new RMIServer();
System.out.println("RMI Server is running");
Naming.rebind("interestServer",server);
}


}
