import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
public class Board 
{

   Socket clientSocket = null;
   OutputStream os = null;       
   ObjectOutputStream send = null;
   
   ServerSocket sSocket = null;        
   Socket socket = null;  
   InputStream is = null;  
   ObjectInputStream recieve = null;
  

   ArrayList<JToggleButton> vCards = new ArrayList<JToggleButton>();
   ArrayList<JPanel> hSleeve = new ArrayList<JPanel>();
   ArrayList<Card> dCards = new ArrayList<Card>();
   ArrayList<JToggleButton> toggled = new ArrayList<JToggleButton>();
   ArrayList<JToggleButton> toggledB = new ArrayList<JToggleButton>();
   
   ArrayList<Hand> hands = new ArrayList<Hand>();
   ArrayList<HandO> handsO = new ArrayList<HandO>();
   
   boolean cardSelected = false;
   int currentSelection = -1;
   boolean alive = true;
   boolean winstate = false;
   boolean canSteal = false;
   
   boolean vMode = false;
   int height = (int)(.95*Toolkit.getDefaultToolkit().getScreenSize().getHeight());
   int width = (int)(.95*Toolkit.getDefaultToolkit().getScreenSize().getWidth());
   int bottomBound = (int)(height *.3);
   double percentage = .2;
   int numCards = 0;
   
   previousCard previous = new previousCard(bottomBound);
   
   boolean reservedConnection = false;
   boolean connectionState = false;
   boolean open = true;
   
   int port = 0;
   String name = null;
   boolean notNamed = true;
   
   boolean canTransfer = false;
   
   JFrame window = new JFrame("We Didn't Playtest This At All");
   JPanel masterPanel = new JPanel(new BorderLayout());
   TextField inputBox = new TextField(35);
   JPanel center = new JPanel();
   JPanel table = new JPanel(); 
   JPanel buttons = new JPanel();   
   JPanel buttonHolder = new JPanel();     
   JPanel hand = new JPanel(); 
   JPanel stealButton = new JPanel();
   
   JPanel cake = new JPanel();
   JPanel presents = new JPanel();
   JPanel kitten = new JPanel();
   JPanel fingers = new JPanel();
   JPanel RPS = new JPanel();
   JPanel winPoints = new JPanel();
   
   JPanel leftSide = new JPanel(); 
   JPanel leftSideAlt = new JPanel();
   JPanel leftLayers = new JPanel(); 
   ImageIcon tButton = new javax.swing.ImageIcon("Buttons/defaultButton.png");
   ImageIcon tButtonRoll = new ImageIcon("Buttons/defaultButtonRoll.png");
   
   public Board()
   {
      try
      {
         clientSocket =  new Socket("192.168.1.104",1987);
         os = clientSocket.getOutputStream();
         send = new ObjectOutputStream(os);
         sSocket = new ServerSocket(1988);            
         socket = sSocket.accept();  
         is = socket.getInputStream();
         recieve = new ObjectInputStream(is);
         port = (Integer)recieve.readObject();
         refreshConnection();
      }
      catch(Exception e)
      {
         System.out.println(e + " Initialize");
      }
   
      inputBox.addActionListener(
            new ActionListener()
            {    
               public void actionPerformed(ActionEvent e) 
               {
                  String s = ((TextField)e.getSource()).getText();
               
                  name = s;
                  try
                  {
                     send.writeObject(s);
                     System.out.println("Name submitted: " + s);
                     notNamed = false;
                     buttonHolder.setVisible(true);
                     previous.previous.setVisible(true);
                  }
                  catch(Exception ex)
                  {
                     System.out.println(ex + " Text Input");
                  }
                  ((TextField)e.getSource()).setText("");
                  ((TextField)e.getSource()).setVisible(false);
               }
            });
   
      window.setDefaultLookAndFeelDecorated(true);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      window.setSize(width, height);
      center.setBackground(Color.PINK);
      leftSide.setBackground(Color.PINK);
      leftSideAlt.setBackground(Color.PINK);
      leftLayers.setBackground(Color.PINK);
      buttons.setBackground(Color.PINK);
      fingers.setBackground(Color.PINK);
      cake.setBackground(Color.PINK);
      presents.setBackground(Color.PINK);
      kitten.setBackground(Color.PINK);
      winPoints.setBackground(Color.PINK);
      RPS.setBackground(Color.PINK);
      stealButton.setBackground(Color.PINK);
      buttonHolder.setBackground(Color.PINK);
      hand.setBackground(Color.PINK);
      
      center.add(previous.addPrevious());
      center.setLayout(new FlowLayout(FlowLayout.TRAILING));
      
      buttonHolder.setVisible(false);
      fingers.setVisible(false);
      cake.setVisible(false);
      presents.setVisible(false);
      kitten.setVisible(false);
      winPoints.setVisible(false);
      RPS.setVisible(false);
      
      FlowLayout noHgap = new FlowLayout();
      noHgap.setHgap(0);
      leftLayers.setLayout(noHgap);
      FlowLayout noGap = new FlowLayout();
      noGap.setVgap(0);
      noGap.setHgap(0);
      
      buttons.setLayout(new GridLayout(5,2));
      
      addPlayButton();
      addSwapViewButton();
      addDrawButton();
      addTransferButton();
      addGiveButton();
      addSelectButton();
      addRemoveButton();
      addDiscardButton();
      addStealButton();
      addFingerPanel();
      addCakePanel();
      addPresentsPanel();
      addRPSPanel();
      
      leftSide.setLayout(new BoxLayout(leftSide, BoxLayout.PAGE_AXIS));
      leftSideAlt.setLayout(new BoxLayout(leftSideAlt, BoxLayout.PAGE_AXIS));
   
      leftLayers.add(leftSide);
      leftLayers.add(leftSideAlt);
      
      JPanel buttonHolderHolder = new JPanel();
      buttonHolderHolder.setBackground(Color.PINK);
      buttonHolderHolder.add(buttonHolder);
      buttonHolder.setLayout(new BoxLayout(buttonHolder, BoxLayout.PAGE_AXIS));
      cake.setLayout(noGap);
      presents.setLayout(noGap);
      kitten.setLayout(noGap);
      RPS.setLayout(noGap);
      stealButton.setLayout(noGap);
      winPoints.setLayout(noGap);
      
      buttonHolder.add(buttons);
      buttons.add(stealButton);
      buttonHolder.add(fingers);
      buttonHolder.add(cake);
      buttonHolder.add(kitten);
      buttonHolder.add(presents);
      buttonHolder.add(winPoints);
      buttonHolder.add(RPS);
      
      
      //hand.setPreferredSize(new Dimension(width, bottomBound+20));
   
      masterPanel.add(center, BorderLayout.CENTER);
      masterPanel.add(buttonHolderHolder, BorderLayout.EAST);
      masterPanel.add(hand, BorderLayout.SOUTH);
      masterPanel.add(inputBox, BorderLayout.NORTH);
      masterPanel.add(leftLayers, BorderLayout.WEST);
      
   
      window.add(masterPanel);
      
      
      name = "nametag";
   
      window.setVisible(true);
      
      while(open)
      {
         if(!reservedConnection)
         {
            recieveObject();
         }
         try
         {
            Thread.sleep(10);
         }
         catch(Exception e){}
      }
   }
   
   public void recieveObject()
   {
      String s = "";
      try
      {
         s = (String)recieve.readObject();
         //System.out.println(s);
         commandHandler(s);
         connectionState = false;
      }
      catch(Exception e){//System.out.println(e + " recieveObject");
      }
   }
   
   public void commandHandler(String s)
   {
      switch(s)
      {
         case "DRAW ACCEPT":
            drawAccept();
            break;
         case "ERROR":
            errorHandler();
            break;
         case "KITTENS":
            kitten.setVisible(true);
            break;
         case "LOSE":
            System.out.println("LOSE");
            break;
         case "NEW PLAYER":
            addPlayer();
            break;
         case "REMOVE CARD":
            removeCard();
            break; 
         case "REMOVE SELECTION":
            removeSelection();
            break; 
         case "REMOVE SELECTION O":
            removeSelectionO();
            break; 
         case "TAKE POLL CAKE":
            cake.setVisible(true);
            break;
         case "TAKE POLL FINGERS":
         //System.out.println("POLL TAKING");
            fingers.setVisible(true);
            break;
         case "TAKE POLL PRESENTS":
            presents.setVisible(true);
            break;
         case "TAKE POLL BATTLE":
            RPS.setVisible(true);
            break;
         case "TRANSFER CARD":
            canTransfer = true;
            break;
         case "STEAL ENABLED":
            showSteal();
            break;
         case "UPDATE HELD":
            addHeldCard();
            break;
         case "UPDATE BOARD":
            addBoardCard();
            break;
         case "UPDATE PREVIOUS CARD":
            updatePrevious();
            break;
         case "WIN":
            System.out.println("WIN");
            break;
         case "WINPOINTS":
            winPoints();
            break;
      }
      
   }
   
   public void refreshConnection()
   {
      if(sSocket != null)
      {
         endConnection();
      }
      try
      {
         clientSocket =  new Socket("192.168.1.104",port);
         os = clientSocket.getOutputStream();
         send = new ObjectOutputStream(os);
         sSocket = new ServerSocket(port+1);          
         socket = sSocket.accept();  
         is = socket.getInputStream(); 
         recieve = new ObjectInputStream(is);
      }
      catch(Exception e)
      {
         System.out.println(e.toString());
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
   
   void errorHandler()
   {
      try
      {
         String s = (String)recieve.readObject();
         System.out.println(s + " ERROR");
      }
      catch(Exception e){System.out.println(e + " ERRORHANDLER");}
   }
   
   public void makeCard(Card c)
   {
      JToggleButton nTCard = new JToggleButton();   
   
      prepButton1(nTCard, 
         new ImageIcon(c.getIcon().getImage().getScaledInstance((int)(.6667*bottomBound),bottomBound,Image.SCALE_SMOOTH )),
         new ImageIcon(c.getRollIcon().getImage().getScaledInstance((int)(.6667*bottomBound),bottomBound,Image.SCALE_SMOOTH )));
   
      JLabel textCont = new JLabel("");
      //add get text
      
      if(!c.name.equals("bk"))
      {
         textCont = new JLabel("", new ImageIcon(c.getTextIcon().getImage().getScaledInstance((int)(.6667*bottomBound),bottomBound,Image.SCALE_SMOOTH )), JLabel.LEFT);
         textCont.setAlignmentX(0.5f);
         textCont.setAlignmentY(0.5f);
         
      }
      else
      {
         //blankGUI();
      }
      JPanel sleeve = new JPanel();
      
      
      sleeve.setBackground(Color.PINK);
      
      LayoutManager overlay = new OverlayLayout(sleeve);
      sleeve.setLayout(overlay);
   
      
               
      sleeve.add(textCont);
      sleeve.add(nTCard);
      
      nTCard.addActionListener(
            new ActionListener(){
               
               
               public void actionPerformed(ActionEvent e) 
               {                 
                  toggleRollover((JToggleButton)e.getSource());
               }
            });
      
      hSleeve.add(sleeve);
      vCards.add(nTCard);
      hand.add(sleeve);
      dCards.add(c);
      numCards++;
      update();
      
   }
   
   public void prepButton1(JToggleButton j, ImageIcon a,ImageIcon b)
   {
      j.setIcon(a);
      j.setRolloverIcon(b);
      
      j.setAlignmentX(0.5f);
      j.setAlignmentY(0.5f);
      
      j.setBorderPainted(false);  
      j.setFocusPainted(false);  
      j.setContentAreaFilled(false);
      j.setMargin(new Insets(0,0,0,0));
   }
   
   public void prepButton2(JButton j, ImageIcon a,ImageIcon b)
   {
      j.setIcon(a);
      j.setRolloverIcon(b);
      
      j.setAlignmentX(0.5f);
      j.setAlignmentY(0.5f);
      
      j.setBorderPainted(false);  
      j.setFocusPainted(false);  
      j.setContentAreaFilled(false);
      j.setMargin(new Insets(0,0,0,0));
   }
   
   public void toggleRollover(JToggleButton j)
   {
      while(toggled.size()!= 0)
      {
         unToggle(toggled.get(0));
      }
      if(currentSelection!= vCards.indexOf(j))
      {
         toggled.add(j);
         Icon temp = j.getIcon();
         j.setIcon(j.getRolloverIcon());
         j.setRolloverIcon(temp);
         select(j);
      }
      else
      {
         deselect(j);
      }
   
   }
   
   public void unToggle(JToggleButton j)
   {
      Icon temp = j.getIcon();
      j.setIcon(j.getRolloverIcon());
      j.setRolloverIcon(temp);
      toggled.remove(j);
   }
   
   public void update()
   {
      window.revalidate();
      window.repaint();
   }
   
   
   
   
   
   public void addPlayer()
   {
      try
      {
         String s = (String)recieve.readObject();
         hands.add(new Hand(port,s,bottomBound,percentage));
         hands.get(hands.size()-1).resize(bottomBound, percentage);
         
         handsO.add(new HandO(port,s,bottomBound,percentage));
         handsO.get(handsO.size()-1).resize(bottomBound, percentage);
         
         leftSide.add(hands.get(hands.size()-1).getHand());
         leftSideAlt.add(handsO.get(handsO.size()-1).getHand());
         window.revalidate();
      }
      catch(Exception e)
      {
         System.out.println(e + " ADD PLAYER");
      } 
   }
  
   public void addHeldCard()
   {
      try
      {
         String playerName = (String)recieve.readObject();
         for(int i = 0; i < handsO.size(); i++)
         {
            if(handsO.get(i).name.equals(playerName))
            {
               Card c = (Card)recieve.readObject();
               handsO.get(i).addCard(c);
               break;
            }
         }
      }
      catch(Exception e)
      {
         System.out.println(e + " ADD HELD CARD");
      }          
   }
   
   public void addBoardCard()
   {
      try
      {
         String playerName = (String)recieve.readObject();
         for(int i = 0; i < hands.size(); i++)
         {
            if(hands.get(i).name.equals(playerName))
            {
               Card c = (Card)recieve.readObject();
               hands.get(i).addCard(c);
               break;
            } 
         }
         update();
      }
      catch(Exception e)
      {
         System.out.println(e + " ADD BOARD CARD");
      }
   }
   
   void updatePrevious()
   {
      try
      {
         Card c = (Card)recieve.readObject();
         previous.editPrevious(c);
         update();
      }
      catch(Exception e)
      {
         System.out.println(e + " PREVIOUS CARD");
      }
   }
   
   
   
   
   
   
   public void  discard()
   {
      if(currentSelection != -1)
      {
         numCards--;
         Card c = dCards.get(currentSelection);
         removeSelection();
         currentSelection = -1;
         try
         {
            send.writeObject("DISCARD");
            send.writeObject(c);
         }
         catch(Exception e){}
         update();
         endConnection();
      }
      
   }
   public void draw()
   {
      try
      {
         send.writeObject("DRAW");        
      }
      catch(Exception e){System.out.println(e + " Draw Card");}
   }
   
   public void drawAccept()
   {
      try
      {
         Card tCard = (Card)recieve.readObject();
         System.out.println("Card Recieved");
         makeCard(tCard);
         connectionState = false;
      }
      catch(Exception e){System.out.println(e + " Draw Accept");}
   }

   public void poll()
   {
      try
      {
         send.writeObject("POLL");
      }
      catch(Exception e){}
   }
   
   public void  play()
   {
      if(currentSelection != -1)
      {  
         Card c = dCards.get(currentSelection);
         try
         {
            send.writeObject("PLAYCARD");
            send.writeObject(c);
            send.writeObject(new Integer(currentSelection));
         
         }
         catch(Exception e){System.out.println(e + " Play");}
         update();
      }
   }
   
   public void removeSelection()
   {
      numCards--;
      dCards.remove(currentSelection);
      hand.remove(hSleeve.get(currentSelection));
      hSleeve.remove(currentSelection);
      vCards.remove(currentSelection);
      currentSelection = -1;
      update();
   }
   
   public void removeCard()
   {
      try
      {
         int i = (Integer)recieve.readObject();
         dCards.remove(i);
         hand.remove(hSleeve.get(i));
         hSleeve.remove(i);
         vCards.remove(i);
         update();
         numCards--;
      }
      catch(Exception e){System.out.println(e + " REMOVE CARD");}
   }
   
   public void removeSelectionO()
   {
      try
      {
         String playerName = (String)recieve.readObject();
         int cCat = (Integer)recieve.readObject();
         int cIndex = (Integer)recieve.readObject();
         if(cCat == 1 || cCat == 2)
         {
            for(int i = 0; i < handsO.size(); i++)
            {
               if(handsO.get(i).name.equals(playerName))
               {
                  handsO.get(i).removeSelection(cIndex);
               }
            }
         }
         else
         {
            for(int i = 0; i < hands.size(); i++)
            {
               if(hands.get(i).name.equals(playerName))
               {
                  hands.get(i).removeSelection(cIndex);
               }
            }
         }
         update();
      }
      catch(Exception e)
      {
         System.out.println(e + " ADD HELD CARD");
      }  
   }
   
   public void select(JToggleButton j)
   {
      cardSelected = true;
      currentSelection = vCards.indexOf(j);
      update();
   }
   public void deselect(JToggleButton j)
   {
      cardSelected = false;
      currentSelection = -1;
      update();
   }

   
   

   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   public void genericButton(String icon ,ActionListener a, double d, JPanel tPanel)
   {
      JButton bPlay = new JButton();   
      prepButton2(bPlay,
         new ImageIcon(tButton.getImage().getScaledInstance((int)(bottomBound*d),(int)(bottomBound*d),Image.SCALE_SMOOTH )),
         new ImageIcon(tButtonRoll.getImage().getScaledInstance((int)(bottomBound*d),(int)(bottomBound*d),Image.SCALE_SMOOTH )));
      JLabel textCont = new JLabel("");
      
      ImageIcon text = new ImageIcon(new ImageIcon(icon).getImage().getScaledInstance((int)(bottomBound*d),(int)(bottomBound*d),Image.SCALE_SMOOTH ));
      textCont = new JLabel("", text, JLabel.LEFT);
      textCont.setAlignmentX(0.5f);
      textCont.setAlignmentY(0.5f);
         
      JPanel sleeve = new JPanel();
         
      sleeve.setBackground(Color.PINK);
      
      LayoutManager overlay = new OverlayLayout(sleeve);
      sleeve.setLayout(overlay);
      
      sleeve.add(textCont);
      sleeve.add(bPlay);
               
      bPlay.addActionListener(a);
      tPanel.add(sleeve);
   }
   
   
   
   public void addDiscardButton()
   {
      String icon = "Buttons/discard.png";
      
      ActionListener a = 
         new ActionListener()
         {    
            public void actionPerformed(ActionEvent e) 
            {            
               discard();     
            }
         };
      genericButton(icon,a,.3333,buttons);
   }
   
   public void addDrawButton()
   {
      String icon = "Buttons/draw.png";
      
      ActionListener a = 
         new ActionListener()
         {    
            public void actionPerformed(ActionEvent e) 
            {            
               draw();
            }
         };
      genericButton(icon,a,.3333,buttons);
   }
   
   public void addGiveButton()
   {
      String icon = "Buttons/give.png";
         
      ActionListener a = 
         new ActionListener()
         {    
            public void actionPerformed(ActionEvent e) 
            {           
                  for(int i = 0; i< hands.size(); i++)
                  { 
                     if(currentSelection != -1 && (hands.get(i).selected || handsO.get(i).selected))
                     {  
                        Card c = dCards.get(currentSelection);
                        try
                        {
                           send.writeObject("GIVE CARD");
                           send.writeObject(c);
                           send.writeObject(new Integer(currentSelection));
                           send.writeObject(hands.get(i).name);
                        }
                        catch(Exception ex){System.out.println(ex + " GIVE");}
                        update();
                     }    
                  }
            }
         };
      genericButton(icon,a,.3333,buttons);
   }
   public void addPlayButton()
   {
      String icon = "Buttons/play.png";
      
      ActionListener a = 
         new ActionListener()
         {    
            public void actionPerformed(ActionEvent e) 
            {            
               play();     
            }
         };
      genericButton(icon,a,.3333,buttons);
   }
   
   public void addPollButton()
   {
      String icon = "Buttons/poll.png";
      
      ActionListener a = 
         new ActionListener()
         {    
            public void actionPerformed(ActionEvent e) 
            {            
               poll();  
            }
         };
      genericButton(icon,a,.3333,buttons);
   }
   
   public void addRemoveButton()
   {
      String icon = "Buttons/remove.png";
      
      ActionListener a = 
         new ActionListener()
         {    
            public void actionPerformed(ActionEvent e) 
            {            
               for(int i = 0; i < hands.size(); i++)
               {
                  if(hands.get(i).isSelected()!=-1)
                  {
                     System.out.println(hands.get(i).getSelected().name);
                     System.out.println("" + hands.get(i).owner);
                     hands.get(i).removeCurrentSelection();
                  }
               }
            }
         };
      genericButton(icon,a,.3333,buttons);
   }
   
   public void addSwapViewButton()
   {
      String icon = "Buttons/swapView.png";
      
      ActionListener a = 
         new ActionListener()
         {    
            public void actionPerformed(ActionEvent e) 
            {        
               for(int i = 0; i < hands.size();i++)
               {
                  hands.get(i).setVisibility(!vMode);
                  if(!vMode)
                  {
                     hands.get(i).resize(bottomBound,percentage);
                     hands.get(i).selected = false;
                     hands.get(i).selectionIndex = -1;
                  }
               }  
               for(int i = 0; i < handsO.size();i++)
               {
                  handsO.get(i).setVisibility(vMode);
                  if(vMode)
                  {
                     handsO.get(i).resize(bottomBound,percentage);
                     handsO.get(i).selected = false;
                     handsO.get(i).selectionIndex = -1;
                  }
               }  
               vMode = !vMode;
            }
         };
      genericButton(icon,a,.3333,buttons);
   }
   
   public void addStealButton()
   {
      String icon = "Buttons/steal.png";
      
      ActionListener a = 
         new ActionListener()
         {    
            public void actionPerformed(ActionEvent e) 
            {        
               //if(canSteal)
              // {
                  Card c;
                  for(int i = 0; i < handsO.size(); i++)
                  {
                     if(handsO.get(i).selected && handsO.get(i).selectionIndex!=-1)
                     {
                        c = handsO.get(i).getSelected();
                        try
                        {
                           send.writeObject("THEFT");
                           send.writeObject(handsO.get(i).name);
                           send.writeObject(new Integer(1));
                           send.writeObject(new Integer(handsO.get(i).selectionIndex));
                           send.writeObject(c);
                        }
                        catch(Exception ex){System.out.println(ex+" STEAL");}
                        handsO.get(i).selected= false;
                        handsO.get(i).selectionIndex=-1;      
                        handsO.get(i).resize(bottomBound,percentage);           
                       
                     }
                //  }  
               }
            }
         };
      genericButton(icon,a,.3333,stealButton);
      Component[] components = stealButton.getComponents();
      components = ((JPanel)components[0]).getComponents();
      ((JButton)components[1]).setIcon(new ImageIcon(tButtonRoll.getImage().getScaledInstance((int)(bottomBound*.3333),(int)(bottomBound*.3333),Image.SCALE_SMOOTH )));
   }
   
   public void addTransferButton()
   {
      String icon = "Buttons/send.png";
      
      ActionListener a = 
         new ActionListener()
         {    
            public void actionPerformed(ActionEvent e) 
            {     
               if(canTransfer)
               { 
                  Card c;
                  for(int i = 0; i < hands.size(); i++)
                  {
                     if(hands.get(i).selected && hands.get(i).selectionIndex!=-1 && hands.get(i).name.equals(name))
                     {
                        c = hands.get(i).getSelected();
                        try
                        {
                           send.writeObject("TRANSFER CARD");
                           send.writeObject(hands.get(i).name);
                           send.writeObject(new Integer(hands.get(i).selectionIndex));
                           send.writeObject(c);
                        }
                        catch(Exception ex){System.out.println(ex+" TRANSFER");}
                        hands.get(i).selected= false;
                        hands.get(i).selectionIndex=-1;      
                        hands.get(i).resize(bottomBound,percentage);           
                        
                     }
                  }
                  canTransfer = false;  
               }
            }
         };
      genericButton(icon,a,.3333,buttons);
   }
   
   public void addSelectButton()
   {
      String icon = "Buttons/take.png";
      
      ActionListener a = 
         new ActionListener()
         {    
            public void actionPerformed(ActionEvent e) 
            {        
                  for(int i = 0; i < hands.size(); i++)
                  {
                     if(hands.get(i).selected || handsO.get(i).selected)
                     {
                        try
                        {
                           send.writeObject("SELECT");
                           send.writeObject(hands.get(i).name);
                        }
                        catch(Exception ex){System.out.println(ex+" Selected");}
                        hands.get(i).selected= false;
                        hands.get(i).selectionIndex=-1;      
                        hands.get(i).resize(bottomBound,percentage);    
                        handsO.get(i).selected= false;
                        handsO.get(i).selectionIndex=-1;      
                        handsO.get(i).resize(bottomBound,percentage);       
                        
                     }
                  }  
               
            }
         };
      genericButton(icon,a,.3333,buttons);
   }
   
   void addCakePanel()
   {
      String icon = "Buttons/cake.png";
      ActionListener a = 
         new ActionListener()
         {    
            public void actionPerformed(ActionEvent e) 
            {            
               try
               {
                  send.writeObject("POLL RETURN");
                  send.writeObject(new Integer(1)); 
                  cake.setVisible(false);
               }
               catch(Exception ex){System.out.println(ex + " CAKE");}    
            }
         };
      genericButton(icon,a,.3333,cake);
      
      icon = "Buttons/death.png";
      a = 
         new ActionListener()
         {    
            public void actionPerformed(ActionEvent e) 
            {            
               try
               {
                  send.writeObject("POLL RETURN");
                  send.writeObject(new Integer(2)); 
                  cake.setVisible(false);
               }
               catch(Exception ex){System.out.println(ex + " CAKE");}    
            }
         };
      genericButton(icon,a,.3333,cake);
   }
   
   void addFingerPanel()
   {
      fingers.setLayout(new GridLayout(1,5));
      addFingerButton("one", 1);
      addFingerButton("two", 2);
      addFingerButton("three", 3);
      addFingerButton("four", 4);
      addFingerButton("five", 5);
   }
   
   public void addFingerButton(String s , int i)
   {
      String icon = "Buttons/" + s + "Finger.png";
      ActionListener a=new ActionListener(){public void actionPerformed(ActionEvent e) {}};
      switch(i)
      {
         case 1:
            a =new ActionListener()
            {    
               public void actionPerformed(ActionEvent e) 
               {            
                  try
                  {
                     send.writeObject("POLL RETURN");
                     send.writeObject(new Integer(1)); 
                     fingers.setVisible(false);
                  }
                  catch(Exception ex){System.out.println(ex + " FINGERS");}    
               }
            }; break;
            case 2:
            a=new ActionListener()
            {    
               public void actionPerformed(ActionEvent e) 
               {            
                  try
                  {
                     send.writeObject("POLL RETURN");
                     send.writeObject(new Integer(2)); 
                     fingers.setVisible(false);
                  }
                  catch(Exception ex){System.out.println(ex + " FINGERS");}    
               }
            }; break;
            case 3:
            a=new ActionListener()
            {    
               public void actionPerformed(ActionEvent e) 
               {            
                  try
                  {
                     send.writeObject("POLL RETURN");
                     send.writeObject(new Integer(3)); 
                     fingers.setVisible(false);
                  }
                  catch(Exception ex){System.out.println(ex + " FINGERS");}    
               }
            }; break;
            case 4:
            a=new ActionListener()
            {    
               public void actionPerformed(ActionEvent e) 
               {            
                  try
                  {
                     send.writeObject("POLL RETURN");
                     send.writeObject(new Integer(4)); 
                     fingers.setVisible(false);
                  }
                  catch(Exception ex){System.out.println(ex + " FINGERS");}    
               }
            }; break;
            case 5:
            a=new ActionListener()
            {    
               public void actionPerformed(ActionEvent e) 
               {            
                  try
                  {
                     send.writeObject("POLL RETURN");
                     send.writeObject(new Integer(5)); 
                     fingers.setVisible(false);
                  }
                  catch(Exception ex){System.out.println(ex + " FINGERS");}    
               }
            }; break;
      }
      genericButton(icon,a,.11,fingers);
   }
   
   void addPresentsPanel()
   {
      String icon = "Buttons/present.png";
      ActionListener a = 
         new ActionListener()
         {    
            public void actionPerformed(ActionEvent e) 
            {            
               try
               {
                  send.writeObject("POLL RETURN");
                  send.writeObject(new Integer(1)); 
                  presents.setVisible(false);
               }
               catch(Exception ex){System.out.println(ex + " PRESENTS");}    
            }
         };
      genericButton(icon,a,.3333,presents);
      
      icon = "Buttons/nopresent.png";
      a = 
         new ActionListener()
         {    
            public void actionPerformed(ActionEvent e) 
            {            
               try
               {
                  send.writeObject("POLL RETURN");
                  send.writeObject(new Integer(2)); 
                  presents.setVisible(false);
               }
               catch(Exception ex){System.out.println(ex + " PRESENTS");}    
            }
         };
      genericButton(icon,a,.3333,presents);
   }
   
   void addKittenPanel()
   {
      String icon = "Buttons/kitteh.png";
      ActionListener a = 
         new ActionListener()
         {    
            public void actionPerformed(ActionEvent e) 
            {            
               try
               {
                  send.writeObject(new Integer(1)); 
                  kitten.setVisible(false);
               }
               catch(Exception ex){System.out.println(ex + " DESTROYK");}    
            }
         };
      genericButton(icon,a,.3333,kitten);
      
      icon = "Buttons/draw3.png";
      a = 
         new ActionListener()
         {    
            public void actionPerformed(ActionEvent e) 
            {            
               try
               {
                  send.writeObject(new Integer(2));
                  kitten.setVisible(false);
               }
               catch(Exception ex){System.out.println(ex + " KITTEH");}    
            }
         };
      genericButton(icon,a,.3333,kitten);
   }
   
   void showKitten()
   {
      kitten.setVisible(true);
   }
   
   void addRPSPanel()
   {
      String icon = "Buttons/rock.png";
      ActionListener a = 
         new ActionListener()
         {    
            public void actionPerformed(ActionEvent e) 
            {            
               try
               {
                  send.writeObject("POLL RETURN");
                  send.writeObject(new Integer(1)); 
                  RPS.setVisible(false);
               }
               catch(Exception ex){System.out.println(ex + " ROCK");}    
            }
         };
      genericButton(icon,a,.21,RPS);
      
      icon = "Buttons/paper.png";
      a = 
         new ActionListener()
         {    
            public void actionPerformed(ActionEvent e) 
            {            
               try
               {
                  send.writeObject("POLL RETURN");
                  send.writeObject(new Integer(2)); 
                  RPS.setVisible(false);
               }
               catch(Exception ex){System.out.println(ex + " PAPER");}    
            }
         };
      genericButton(icon,a,.21,RPS);
      
      icon = "Buttons/scissors.png";
      a = 
         new ActionListener()
         {    
            public void actionPerformed(ActionEvent e) 
            {            
               try
               {
                  send.writeObject("POLL RETURN");
                  send.writeObject(new Integer(3)); 
                  RPS.setVisible(false);
               }
               catch(Exception ex){System.out.println(ex + " PAPER");}    
            }
         };
      genericButton(icon,a,.21,RPS);
   }
   
   void showSteal()
   {
      Component[] components = stealButton.getComponents(); 
      components = ((JPanel)components[0]).getComponents();
      ((JButton)components[1]).setIcon(new ImageIcon(tButton.getImage().getScaledInstance((int)(bottomBound*.3333),(int)(bottomBound*.3333),Image.SCALE_SMOOTH )));
   
   }
   
   void winPoints()
   {
      winPoints.setVisible(true);
      winPoints.removeAll();
      try
      {
         String s = (String)recieve.readObject();
            String icon = "Buttons/"+ s + ".png";
            ActionListener a = 
               new ActionListener()
               {    
                  public void actionPerformed(ActionEvent e) 
                  {            
                     try
                     {
                        send.writeObject(new Integer(1)); 
                        winPoints.setVisible(true);
                     }
                     catch(Exception ex){System.out.println(ex + " WIN CONDITION");}    
                  }
               };
            genericButton(icon,a,.3333,winPoints);
            
            icon = "Buttons/fivePoints.png";
            a = 
               new ActionListener()
               {    
                  public void actionPerformed(ActionEvent e) 
                  {            
                     try
                     {
                        send.writeObject(new Integer(2));
                        winPoints.setVisible(false);
                     }
                     catch(Exception ex){System.out.println(ex + " FIVE POINTS");}    
                  }
               };
            genericButton(icon,a,.3333,winPoints);
         }
      catch(Exception e){System.out.println(e + " WINPOINTS");}
   }
}