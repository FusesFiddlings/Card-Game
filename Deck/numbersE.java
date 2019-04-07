
import javax.swing.*;
   public class numbersE extends Card
   {
      public numbersE()
      {
      
         this.name = "numbersE";
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
			return new ImageIcon("Cards/numbersEZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/numbersE.png");
		}
      public String command()
      {
         return "FINGERS";
      }
   }