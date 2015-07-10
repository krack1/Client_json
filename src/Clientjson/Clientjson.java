package Clientjson;

import org.json.simple.JSONObject;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.io.FileWriter;


public class Clientjson {
	
	public Clientjson(String ip, int port) {
		Socket socket = null;
		OutputStream out = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		
		
		try {
			Thread.sleep(1000);
			socket = new Socket(ip, port);
			
			JSONObject obj = new JSONObject();
			
			Scanner sc = new Scanner(System.in);
			System.out.print("input (light sat bri hue) : \n");
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
		      
		      obj.put("light", new Integer(a));
		      obj.put("sat", new  Integer(b));
		      obj.put("bri", new Integer(c));
		      obj.put("hue", new Integer(d));
			
			out = socket.getOutputStream();
			osw = new OutputStreamWriter(out);
			bw = new BufferedWriter(osw);
			String jsonString = obj.toString();
			
			bw.write(jsonString);

			sc.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				bw.close();
				osw.close();
				out.close();
				socket.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]) {

		Clientjson client = new Clientjson("127.0.0.1", 5559);
		
	}
	
}
