
import javax.swing.*;
   public class shield extends Card
   {
      public shield()
      {
      
         this.name = "shield";
         this.type = 2;
			this.star = false;
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
			return new ImageIcon("Cards/shieldZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/shield.png");
		}
      public String command()
      {
         return "shield";
      }
   }