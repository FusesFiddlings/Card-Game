
import javax.swing.*;
   public class lose extends Card
   {
      public lose()
      {
      
         this.name = "lose";
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
			return new ImageIcon("Cards/loseZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/lose.png");
		}
      public String command()
      {
         return "lose";
      }
   }