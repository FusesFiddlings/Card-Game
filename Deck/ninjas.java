
import javax.swing.*;
   public class ninjas extends Card
   {
      public ninjas()
      {
      
         this.name = "ninjas";
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
			return new ImageIcon("Cards/ninjasZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/ninjas.png");
		}
      public String command()
      {
         return "ninjas";
      }
   }