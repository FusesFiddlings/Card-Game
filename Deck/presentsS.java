
import javax.swing.*;
   public class presentsS extends Card
   {
      public presentsS()
      {
      
         this.name = "presentsS";
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
			return new ImageIcon("Cards/presentsSZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/presentsS.png");
		}
      public String command()
      {
         return "PRESENTS";
      }
   }