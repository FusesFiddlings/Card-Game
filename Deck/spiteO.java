
import javax.swing.*;
   public class spiteO extends Card
   {
      public spiteO()
      {
      
         this.name = "spiteO";
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
			return new ImageIcon("Cards/spiteOZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/spiteO.png");
		}
      public String command()
      {
         return "spite";
      }
   }