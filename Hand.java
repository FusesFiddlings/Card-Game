import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;
public class Hand implements java.io.Serializable
{
	int owner;
	ArrayList<JPanel> cards = new ArrayList<JPanel>();
	ArrayList<Card> pBoard = new ArrayList<Card>();
	JPanel hand;
	
	int selectionIndex = -1;
	int bottomBoundO;
	double percentageO;
	
	String name;
	
	boolean selected = false;
	
	public Hand(int i, String s, int bottomBound, double percentage)
	{
		bottomBoundO = bottomBound;
		percentageO = percentage;
		owner = i;
		name = s;
		JPanel sleeve = new JPanel();
		sleeve.setBackground(Color.PINK);
		JButton tButton = new JButton();
		
		tButton.setIcon(new ImageIcon("Nametags/" + name + ".png"));
		tButton.setBorderPainted(false);  
      tButton.setFocusPainted(false);  
      tButton.setContentAreaFilled(false);
		tButton.setMargin(new Insets(0,0,0,0));
		tButton.addActionListener(new ActionListener()
		{        
         public void actionPerformed(ActionEvent e) 
         {
				selected = !selected;
				if(selected)
				{
					resize(bottomBoundO,percentageO*2);
				}
				else
				{
					selectionIndex = -1;
					resize(bottomBoundO,percentageO);
				}		
         }
		});
		
		sleeve.add(tButton);
		sleeve.setAlignmentX(0.5f);
      sleeve.setAlignmentY(0.5f);
		cards.add(sleeve);
		
		hand = new JPanel();
		hand.setBackground(Color.PINK);
		hand.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		hand.add(cards.get(0));
		
	}
	public void addCard(Card c)
	{
		pBoard.add(c);
		JPanel sleeve = new JPanel();
		LayoutManager overlay = new OverlayLayout(sleeve);
      sleeve.setLayout(overlay);
		sleeve.setBackground(Color.PINK);
		JButton tButton = new JButton("", c.getRollZIcon());
		
		tButton.setAlignmentX(0.5f);
      tButton.setAlignmentY(0.5f);
         
      tButton.setBorderPainted(false);  
      tButton.setFocusPainted(false);  
      tButton.setContentAreaFilled(false);
		
		tButton.setMargin(new Insets(0,0,0,0));
			
			tButton.addChangeListener(new ChangeListener()
			{
		  		public void stateChanged(ChangeEvent e)
				{
					if(selected)
					{
						int i = -1;
						for(int j = 0; j < cards.size(); j++)
						{
							if(j!=0)
							{
								Component[] components = cards.get(j).getComponents();
								if(((JButton)components[0]) == ((JButton)e.getSource()))
								{
									i = j-1;
									break;
								}
							}
						}
				      boolean rollover = ((JButton)e.getSource()).getModel().isRollover();
				      if (rollover) 
						{
							((JButton)e.getSource()).setIcon(new ImageIcon(pBoard.get(i).getRollZIcon().getImage().getScaledInstance((int)(2.6667*bottomBoundO*percentageO),(int)(bottomBoundO*percentageO*4),Image.SCALE_SMOOTH )));
	
						}
						else
						{
							resize(bottomBoundO,percentageO*2);
						}
					}
				}
			});
			
		tButton.addActionListener(new ActionListener()
		{   
			public void actionPerformed(ActionEvent e) 
         {
				if(selected)
				{
					for(int j = 0; j < cards.size(); j++)
					{
						if(j!=0)
						{
							Component[] components = cards.get(j).getComponents();
							if(((JButton)components[0]) == ((JButton)e.getSource()))
							{
								selectionIndex = j-1;
								break;
							}
						}
					}
				}
         }
		});

		sleeve.add(tButton);
		cards.add(sleeve);
		hand.add(sleeve);
		resize(bottomBoundO,percentageO);
	}
	
	public void resize(int bottomBound, double percentage)
	{
		for(int i = 0; i < cards.size(); i++)
		{
			
			Component[] components = cards.get(i).getComponents();
			if(i == 0)
			{
				((JButton)components[0]).setIcon(new ImageIcon((new ImageIcon("Nametags/" + name + ".png")).getImage().getScaledInstance((int)(.6667*bottomBound*percentage),(int)(bottomBound*percentage),Image.SCALE_SMOOTH )));
			}
			else
			{
				if(i!=selectionIndex+1)
				{
					((JButton)components[0]).setIcon(new ImageIcon((pBoard.get(i-1).getRollZIcon()).getImage().getScaledInstance((int)(.6667*bottomBound*percentage),(int)(bottomBound*percentage),Image.SCALE_SMOOTH )));
				}
			}
		}
	}
	public JPanel getHand()
	{
		resize(bottomBoundO, percentageO);
		hand.setVisible(false);
		return hand;
	}
	public int isSelected()
	{
		return selectionIndex;
	}
	
	public Card getSelected()
	{
		return pBoard.get(selectionIndex);
	}
	
	public void removeCurrentSelection()
	{
		hand.remove(cards.get(selectionIndex+1));
		cards.remove(selectionIndex+1);
		pBoard.remove(selectionIndex);
		selectionIndex = -1;
		selected = false;
		resize(bottomBoundO, percentageO);
	}
   
   public void removeSelection(int i)
	{
		hand.remove(cards.get(i+1));
		cards.remove(i+1);
		pBoard.remove(i);
		selectionIndex = -1;
		selected = false;
		resize(bottomBoundO, percentageO);
	}
   
	public void setVisibility(boolean b)
	{
		hand.setVisible(b);
	}
	public boolean getVisibility()
	{
		return hand.isVisible();
	}
}