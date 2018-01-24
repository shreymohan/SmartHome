package iot;

import java.io.*;
import java.net.ServerSocket;
import java.net.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class floor1 extends rasberrypi1 implements Runnable {
	 Thread th;	
	 Connection con = null;
	 Statement st = null;
	 ResultSet rs = null;    
	 public void sensorCheck(){
	 	// String state;
		 th=new Thread(this,"thread1");
		 String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
	     String url = "jdbc:mysql://localhost/student";
	     String user = "root";
	     String password = "";

	     try {
	         Class.forName("com.mysql.jdbc.Driver");
	         System.out.println("Connecting to database...");
	         con = DriverManager.getConnection(url, user, password);
	         System.out.println("Creating statement...");
	         st = con.createStatement();
	         rs = st.executeQuery("SELECT * FROM light ;");
	         th.start();
	         	 }
	     catch(Exception e){
	     	e.printStackTrace();
	     	System.out.println("Error: unable to load driver class!");
	     }		     
	     	 }
	 public void run(){
			
		 try{
				while(rs.next()){
					switch(rs.getString(2)){
					case "security system":
						if(rs.getString(3).equals("armed"))
							secSystem="Armed";
						else
							secSystem="disarmed";
					    break;
					case "garage_door_onecar":
						if(rs.getString(3).equals("open"))
					        garageDoor1="open";
						else
							garageDoor1="closed";
						break;
                                                case "garage_door_twocar":
						if(rs.getString(3).equals("open"))
					        garageDoor2="open";
						else
							garageDoor2="closed";
						break;
					   case "thermostat":
						curTemp=rs.getString(3);
						break;
                                          
					case "light":
						if(rs.getString(3).equals("on"))
							light="on";
						else 
							light="off";
						break;
					case "frontdoor":
					     if(rs.getString(3).equals("Locked"))
					    	 frontdoor="locked";
					     else
					    	 frontdoor="unlocked";
					     break;
					case "door_window":
						if(rs.getString(3).equals("On"))
							windowSense="on";
						else
							windowSense="off";
						break;
					case "motion_detector":
						if(rs.getString(3).equals("active"))
							motionDetect="active";
						else
							motionDetect="Inactive";
						break;
					default:
						break;
					}
				}
			//	sc.socketConnect(curTemp);
			
			Thread.sleep(1000);
			}
			
			catch(Exception e){}
		}
	 public static void main(String[] args) throws IOException,InterruptedException{
		 
		 floor1 f1=new floor1();
		 nmap nm=new nmap();
		 processBuilder pb=new processBuilder();       
		 System.out.println(" Connecting to Pi..");
		        	
			         boolean flag=nm.nmapStatus();
			         //System.out.println("f3");
			         ServerSocket ss=new ServerSocket(5000);
						ss.setSoTimeout(60000);
						Socket server = ss.accept();
				         InputStream in=server.getInputStream();
				         DataInputStream i=new DataInputStream(in);
				         DataOutputStream o=new DataOutputStream(server.getOutputStream());  
			         
			         pb.fileBuilder();
			         System.out.println("f8");
			         o.writeUTF("ready");
			         System.out.println("f9");
			         fileSender fs=new fileSender();
			         fs.fileSend();
			         System.out.println("f10");
			         

			         if(flag==true){        
				while(true){ 
				try{
				 //System.out.println("The Security System of floor 1 is "+secSystem);
				 //System.out.println("The Garage door for one car is "+garageDoor1);
				 System.out.println("The Current Temperature at floor 1 is "+curTemp);
		                 //System.out.println("The Garage door for two cars is "+garageDoor2);
				 System.out.println("The Lights at floor 1 are "+light);
				 
				 //System.out.println("The Window sensor at floor 1 is "+windowSense);
				 //System.out.println("The Motion detector at floor 1 is "+motionDetect);
				 
				// sc.socketConnect(curTemp);
				 o.writeUTF(light);
				 o.writeUTF(curTemp);
			     	 Thread.sleep(2000); 
			     						    
                
               
				}
				
				catch(Exception e)
		        	{
		            		System.out.println(e);
		        	}
				f1.sensorCheck();
				
				}	
			 }
			 else{
				 server.close();
				 System.out.println("Raspberry pi Disconnected");
				 
			 }
				 
			       	 
		         
		        }
}

