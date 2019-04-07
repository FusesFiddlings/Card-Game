
import javax.swing.*;
   public class battleS extends Card
   {
      public battleS()
      {
      
         this.name = "battleS";
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
			return new ImageIcon("Cards/battleSZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/battleS.png");
		}
      public String command()
      {
         return "BATTLE";
      }
   }