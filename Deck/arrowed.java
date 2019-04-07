
import javax.swing.*;
   public class arrowed extends Card
   {
      public arrowed()
      {
      
         this.name = "arrowed";
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
			return new ImageIcon("Cards/arrowedZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/arrowed.png");
		}
      public String command()
      {
         return "arrowed";
      }
   }