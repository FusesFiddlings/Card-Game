
import javax.swing.*;
   public class lasers extends Card
   {
      public lasers()
      {
      
         this.name = "lasers";
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
			return new ImageIcon("Cards/lasersZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/lasers.png");
		}
      public String command()
      {
         return "lasers";
      }
   }