package Exp1;
import java.util.*; 
public class hashtable {
	 public static void main(String args[]){  
		  Hashtable<Integer,String> hm=new Hashtable<Integer,String>();  
		  
		  hm.put(1241,"pravallika");  
		  hm.put(1243,"rajee");  
		  hm.put(1224,"harshini");  
		  hm.put(1245,"santhi");  
		  
		  for(Map.Entry m:hm.entrySet()){  
		   System.out.println(m.getKey()+" "+m.getValue());  
		  }  
		 }  	
}