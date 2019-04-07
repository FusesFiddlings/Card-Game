import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
public class Player implements Runnable
{
	//volatile ArrayList<Hand> playerBoards = null;
	
	Integer port = -1;
	//private static boolean begin;
	private static Deck deck = null;
	private static 
	Thread runner;
	String name = "";
	ServerSocket sSocket = null;			
   Socket socket = null;  
   InputStream is = null;  
   ObjectInputStream recieve = null;
	
	Socket clientSocket =  null;
   OutputStream os = null;
   ObjectOutputStream send = null;
	
	int winState = 2;
	int owner = port;
	String userID = null;
	boolean open = true;
	
	public Player(Integer I)
	{
		port = I;
		try{Thread.sleep(1000);}catch(Exception e){}
		runner = new Thread(this,port.toString());
		runner.start();
	}
	
	public void run()
	{
		if(!(deck!=null))
			deck = new Deck(0);
		
		refreshConnection();
		
		try
		{
			name = (String)recieve.readObject();
		}
		catch(Exception e){System.out.println(e + " Name");}
		
		while(open)
		{
			try
			{
				recieveObject();
				Thread.sleep(10);
			}
			catch(Exception e){System.out.println(e + " Input Loop");}
		}
	}

	
 	public void refreshConnection()
	{
		try
		{
			sSocket = new ServerSocket(port);  		
		   socket = sSocket.accept();
		   is = socket.getInputStream();  
			recieve = new ObjectInputStream(is);
			
			userID = (("" + socket.getRemoteSocketAddress()).split(":")[0]).substring(1);
				
			clientSocket =  new Socket(userID,port+1);
	      os = clientSocket.getOutputStream();
	      send = new ObjectOutputStream(os);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}  
		
		public void recieveObject()
		{
			String s = "";
			try
			{
				s = (String)recieve.readObject();
				System.out.println(s);
				commandHandler(s);
			}
			catch(Exception e){//System.out.println(e + " recieveObject");
			}
		}
		
		public void endConnection()
		{
			try
			{
				recieve.close();
       		is.close();
         	sSocket.close();
				send.close();
         	os.close();
         	clientSocket.close();
			}
			catch(Exception e){}
		}
		
		public void commandHandler(String s)
		{
			switch(s)
			{
				case "PLAYCARD":
				playCard();
				break;
				case "DRAW":
				drawCard();
				break;
			}
			
		}
		public void playCard()
		{
			try
			{
				Card c = (Card)recieve.readObject();
				//System.out.println(c.name);
			}
			catch(Exception e)
			{
             System.out.println(e + " Play Card");
			}  
		}
		
		public synchronized void drawCard()
		{
			try
			{
				Card c = deck.draw();
				send.writeObject("DRAW ACCEPT");
				send.writeObject(c);
				System.out.println(c.name);
			}
			catch(Exception e)
			{
             System.out.println(e + " Draw Card");
			}  
		}
		public void justLost()
		{
			winState = 0;
		}
		
		public void justWon()
		{
			winState = 0;
		}
		
		public void justRevived()
		{
			winState = 2;
		}
		
		public int getWinState()
		{
			return winState;
		}
		
		public void setWinState(int i)
		{
			winState = i;
		}
		
		public void reset()
		{
		//
		}
}