
import javax.swing.*;
   public class winGuy extends Card
   {
      public winGuy()
      {
      
         this.name = "winGuy";
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
			return new ImageIcon("Cards/winGuyZ.png");
		}
		
		public ImageIcon getTextIcon()
		{
			return new ImageIcon("Cards/winGuy.png");
		}
      public String command()
      {
         return "winGuy";
      }
   }