
import javax.swing.*;
   public class battleP extends Card
   {
      public battleP()
      {
      
         this.name = "battleP";
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
			return new ImageIcon("Cards/battlePZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/battleP.png");
		}
      public String command()
      {
         return "BATTLE";
      }
   }