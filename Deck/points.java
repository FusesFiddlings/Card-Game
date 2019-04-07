
import javax.swing.*;
   public class points extends Card
   {
      public points()
      {
      
         this.name = "points";
         this.type = 3;
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
			return new ImageIcon("Cards/pointsZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/points.png");
		}
      public String command()
      {
         return "points";
      }
   }