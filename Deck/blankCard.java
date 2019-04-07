import javax.swing.*;
public class blankCard extends Card
{
	public blankCard()
	{
		
		this.name = "bk";
		this.type =0;
	}
	
	public ImageIcon getIcon()
	{
		return new ImageIcon("Cards/card.png");
	}
	
	public ImageIcon getRollIcon()
	{
		return new ImageIcon("Cards/cardRoll.png");
	}
	
	public ImageIcon getRollZIcon()
	{
		return new ImageIcon("Cards/card.png");
	}
	
	public ImageIcon getTextIcon()
	{
		return new ImageIcon("Cards/blank.png");
	}
}