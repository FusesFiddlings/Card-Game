import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
public class Hydra
{
	public static void main(String args[])
	{
		boolean open = true;
		Integer port = new Integer(2000);
		ArrayList<Player> players = new ArrayList<Player>();
		
		Socket clientSocket = null;
	   OutputStream os = null;	      
		ObjectOutputStream send = null;
		
		ServerSocket sSocket = null;			
  		Socket socket = null;  
  		InputStream is = null;  
   	ObjectInputStream recieve = null;
		try
		{
			sSocket = new ServerSocket(1987);
		}
		catch(Exception e){} 	
		
		while(open)
		{
			try
			{
			   socket = sSocket.accept();  
				String userID = (("" + socket.getRemoteSocketAddress()).split(":")[0]).substring(1);
				System.out.println("Connection Accepted From " + userID);	
					
				clientSocket =  new Socket(userID,1988);
		      os = clientSocket.getOutputStream();
		      send = new ObjectOutputStream(os);
							
				Player p = new Player(port);
				send.writeObject(port);
				
				port+=2;	
			}
			catch(Exception e){System.out.println(e + " InitializeD");}
		}
	}
}