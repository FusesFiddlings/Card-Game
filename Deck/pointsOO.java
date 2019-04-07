
import javax.swing.*;
   public class pointsOO extends Card
   {
      public pointsOO()
      {
      
         this.name = "pointsOO";
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
			return new ImageIcon("Cards/pointsOOZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/pointsOO.png");
		}
      public String command()
      {
         return "points";
      }
   }