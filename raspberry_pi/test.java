import java.sql.*;
import java.util.Properties;
import java.net.*;
import java.io.*;

public class test
{
  // The JDBC Connector Class.
  private static final String dbClassName = "com.mysql.jdbc.Driver";

  // Connection string. emotherearth is the database the program
  // is connecting to. You can include user and password after this
  // by adding (say) ?user=paulr&password=paulr. Not recommended!

  private static final String CONNECTION =
                          "jdbc:mysql://localhost/iot";
  
  public static void main(String[] args) throws
                             ClassNotFoundException,SQLException,IOException
  {
   try{
   
    String Name=args[0];
		int port=Integer.parseInt(args[1]);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Connecting to "+Name+" on port "+port);
		Socket client=new Socket(Name,port);
		System.out.println("Connecting to "+client.getRemoteSocketAddress());
                InputStream in=client.getInputStream();
                DataInputStream i=new DataInputStream(in);
		
    
    Class.forName(dbClassName);
    
   
    Properties p = new Properties();
    p.put("user","root");
    p.put("password","");
   
    // Now try to connect
    Connection c = DriverManager.getConnection(CONNECTION,p);
    String val,status;
    while(true){
      status=i.readUTF();
      if(status.contains("ready"))
      break;
     }
System.out.println(i);
     
    fileReceive fr=new fileReceive();
    fr.fileReceived();

     while(true){
      
     val=i.readUTF();
     if(val.equalsIgnoreCase("on")){
     String query = "update sensors set status ='on' where sensors='light';";
      PreparedStatement preparedStmt = c.prepareStatement(query);
      preparedStmt.executeUpdate();
     }
     
   else if(val.equalsIgnoreCase("off")){
     String query = "update sensors set status ='off' where sensors='light';";
      PreparedStatement preparedStmt = c.prepareStatement(query);
      preparedStmt.executeUpdate();
     }
   else
    {
     String query = "update sensors set status = ? where sensors='thermostat';";
       
     PreparedStatement preparedStmt = c.prepareStatement(query);
     preparedStmt.setString(1,val);
      preparedStmt.executeUpdate();
      
      System.out.println(val);
}     
	
}
 }   
    
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
   
}
}

class fileReceive{
public void fileReceived() throws
                             ClassNotFoundException,SQLException,IOException{
   
    Socket client=new Socket("192.168.1.2",5002);
		
                InputStream in=client.getInputStream();
                DataInputStream i=new DataInputStream(in);
InputStream in1=client.getInputStream();
    OutputStream out=new FileOutputStream("abc.txt");
    byte[] bytes = new byte[16*1024];
    int count;
        while ((count = in.read(bytes)) > 0) {
            out.write(bytes, 0, count);
        }
     out.close();
     in1.close();
}


}
