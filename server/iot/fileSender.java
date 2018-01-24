package iot;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class fileSender {
public void fileSend()throws IOException,InterruptedException{
	ServerSocket ss=new ServerSocket(5002);
	ss.setSoTimeout(30000);
	Socket server = ss.accept();
     InputStream in=server.getInputStream();
     DataInputStream i=new DataInputStream(in);
     DataOutputStream o=new DataOutputStream(server.getOutputStream());
	File file = new File("F:/statsTest.txt");
    long length = file.length();
    byte[] bytes = new byte[16 * 1024];
    InputStream in1 = new FileInputStream(file);
    OutputStream out = server.getOutputStream();
    int count;
    while ((count = in1.read(bytes)) > 0) {
        out.write(bytes, 0, count);
    }
    out.close();
    in1.close();
}
}
