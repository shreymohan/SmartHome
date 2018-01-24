package iot;
import java.io.*;
import java.util.*;

public class nmap {
	public boolean nmapStatus()throws InterruptedException,IOException{
		String rspimac="B8:27:EB:B2:F6:03";
	     
	    ProcessBuilder builder = new ProcessBuilder("nmap", "-sP", "192.168.1.0/24");
	    
	    File statText = new File("F:/123.txt");
	            FileOutputStream ous = new FileOutputStream(statText);
	            OutputStreamWriter osw = new OutputStreamWriter(ous);    
	            BufferedWriter w = new BufferedWriter(osw);
	            
	    final Process process = builder.start();
	    InputStream is = process.getInputStream();
	    InputStreamReader isr = new InputStreamReader(is);
	    BufferedReader br = new BufferedReader(isr);
	    String line;
	    while ((line = br.readLine()) != null) {
	    	 	 w.write(line);
	    System.out.println(line);
	    if(line.contains(rspimac)){
	    	return true;
	    	
	    }
	    w.write(line);	
	    
	    
	    }
	    if(line==null)
	    w.close();
		return false;
		
		
	}

}
