import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;
public class HandO extends Hand
{
	public HandO(int i, String s, int b, double d)
	{
		super(i,s,b,d);
	}
	public void addCard(Card c)
	{
		pBoard.add(c);
		JPanel sleeve = new JPanel();
		LayoutManager overlay = new OverlayLayout(sleeve);
      sleeve.setLayout(overlay);
		sleeve.setBackground(Color.PINK);
		JButton tButton;
		if(c.star)
		{
			tButton = new JButton("", new ImageIcon("Cards/starBack.png"));
		}
		else
		{	
			tButton = new JButton("", new ImageIcon("Cards/cardBack.png"));
		}
		
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
						boolean star = false;
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
						star = pBoard.get(i).star;
				      boolean rollover = ((JButton)e.getSource()).getModel().isRollover();
						if(star)
						{
					      if (rollover) 
							{
								((JButton)e.getSource()).setIcon(new ImageIcon(new ImageIcon("Cards/starBack.png").getImage().getScaledInstance((int)(2.6667*bottomBoundO*percentageO),(int)(bottomBoundO*percentageO*4),Image.SCALE_SMOOTH )));
							}
						}
						else
						{
						   if (rollover) 
							{
								((JButton)e.getSource()).setIcon(new ImageIcon(new ImageIcon("Cards/cardBack.png").getImage().getScaledInstance((int)(2.6667*bottomBoundO*percentageO),(int)(bottomBoundO*percentageO*4),Image.SCALE_SMOOTH )));
							}
						}
						if(!rollover)
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
					boolean star = pBoard.get(i-1).star;
					if(star)
					{
						((JButton)components[0]).setIcon(new ImageIcon(new ImageIcon("Cards/starBack.png").getImage().getScaledInstance((int)(.6667*bottomBound*percentage),(int)(bottomBound*percentage),Image.SCALE_SMOOTH )));
					}
					else
					{
						((JButton)components[0]).setIcon(new ImageIcon(new ImageIcon("Cards/cardBack.png").getImage().getScaledInstance((int)(.6667*bottomBound*percentage),(int)(bottomBound*percentage),Image.SCALE_SMOOTH )));
					}
				}
			}
		}
	}
	public JPanel getHand()
	{
		hand.setVisible(true);
		return hand;
	}
}