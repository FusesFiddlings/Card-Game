
import javax.swing.*;
   public class blackHole extends Card
   {
      public blackHole()
      {
      
         this.name = "blackHole";
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
			return new ImageIcon("Cards/blackHoleZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/blackHole.png");
		}
      public String command()
      {
         return "blackHole";
      }
   }