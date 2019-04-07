
import javax.swing.*;
   public class battleMe extends Card
   {
      public battleMe()
      {
      
         this.name = "battleMe";
         this.type = 1;
			this.star = true;
      }
		
		public ImageIcon getIcon()
		{
			return new ImageIcon("Cards/star.png");
		}
		
		public ImageIcon getRollIcon()
		{
			return new ImageIcon("Cards/starRoll.png");
		}
		
		public ImageIcon getRollZIcon()
		{
			return new ImageIcon("Cards/battleMeZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/battleMe.png");
		}
      public String command()
      {
         return "BATTLE";
      }
   }