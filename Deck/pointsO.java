
import javax.swing.*;
   public class pointsO extends Card
   {
      public pointsO()
      {
      
         this.name = "pointsO";
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
			return new ImageIcon("Cards/pointsOZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/pointsO.png");
		}
      public String command()
      {
         return "points";
      }
   }