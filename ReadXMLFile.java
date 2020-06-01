import java.io.*;  
import java.util.*;


public class ReadXMLFile {
	
	    // creating a My HashMap to be used as a  Dictionary
	     static Map<String, Integer> yearmap = new HashMap<String,Integer>();
	     
	public static void main(String[] args) throws IOException  {
	    try  
		{  
		  //the file to be opened for reading  
		  FileInputStream myXML=new FileInputStream("dblp-2020-04-01.xml"); 
		  //file to be scanned
		  Scanner sc=new Scanner(myXML);     

		int value=0;
		
		  while(sc.hasNextLine())	//while loop 
		  {  
			   String line = sc.nextLine();
			   if(line.contains("<year>")) {  
				   String str=new String(line);
				   String yearkey= str.substring(6,10);
				   boolean availablekey=yearmap.containsKey(str.substring(6,10));
				      if(availablekey==true) {
					          yearmap.put(str.substring(6,10),yearmap.get(str.substring(6,10))+1); // using put method
				      }
				      else if(availablekey==false){
					   yearmap.put(str.substring(6,10),1);
				      }
		       }
			 
		  } // end of while loop
		  
		  yearmap = new TreeMap<>(yearmap);
	
		  for (String key : yearmap.keySet()) {
		      System.out.println(key+" "+yearmap.get(key));
		   }
		
		}
		catch(IOException e)  //FILENOTFOUNDEXCEPSION
		{  
		 System.out.println("An error occurred.");
		 e.printStackTrace();   
		} 
	 
}
}
		