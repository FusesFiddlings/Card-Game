
import javax.swing.*;
   public class numbersO extends Card
   {
      public numbersO()
      {
      
         this.name = "numbersO";
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
			return new ImageIcon("Cards/numbersOZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/numbersO.png");
		}
      public String command()
      {
         return "FINGERS";
      }
   }