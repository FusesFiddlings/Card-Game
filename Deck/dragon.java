
import javax.swing.*;
   public class dragon extends Card
   {
      public dragon()
      {
      
         this.name = "dragon";
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
			return new ImageIcon("Cards/dragonZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/dragon.png");
		}
      public String command()
      {
         return "dragon";
      }
   }