
import javax.swing.*;
   public class cake extends Card
   {
      public cake()
      {
      
         this.name = "cake";
         this.type = 1;
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
			return new ImageIcon("Cards/cakeZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/cake.png");
		}
      public String command()
      {
         return "cake";
      }
   }