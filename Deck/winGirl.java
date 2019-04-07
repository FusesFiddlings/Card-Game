
import javax.swing.*;
   public class winGirl extends Card
   {
      public winGirl()
      {
      
         this.name = "winGirl";
         this.type = 3;
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
			return new ImageIcon("Cards/winGirlZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/winGirl.png");
		}
      public String command()
      {
         return "winGirl";
      }
   }