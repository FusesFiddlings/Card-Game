
import javax.swing.*;
   public class battleR extends Card
   {
      public battleR()
      {
      
         this.name = "battleR";
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
			return new ImageIcon("Cards/battleRZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/battleR.png");
		}
      public String command()
      {
         return "BATTLE";
      }
   }