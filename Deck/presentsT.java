
import javax.swing.*;
   public class presentsT extends Card
   {
      public presentsT()
      {
      
         this.name = "presentsT";
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
			return new ImageIcon("Cards/presentsTZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/presentsT.png");
		}
      public String command()
      {
         return "PRESENTS";
      }
   }